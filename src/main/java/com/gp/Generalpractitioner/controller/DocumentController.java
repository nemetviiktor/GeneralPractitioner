package com.gp.Generalpractitioner.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gp.Generalpractitioner.service.DocumentService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class DocumentController {

	private DocumentService documentService;

	@Autowired
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public String Pdf(Model model) throws FileNotFoundException, DocumentException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));

		document.open();

		PdfPTable table = new PdfPTable(3);
		addTableHeader(table);
		addRows(table);

		document.add(table);
		document.close();

		return "index";
	}

	@GetMapping(value = "/pdfOpen")
	public void showPDF(HttpServletResponse response) throws IOException {        //<a th:href="@{/pdf/Manjaro-User-Guide.pdf}">Show Pdf file</a>
		response.setContentType("application/pdf");
		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"demo.pdf\"");
		String location = "iTextHelloWorld.pdf";
		InputStream inputStream = new FileInputStream(new File(location));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}
	


	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}
}
