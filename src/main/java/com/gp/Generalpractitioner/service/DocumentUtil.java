package com.gp.Generalpractitioner.service;

import java.io.IOException;

import com.gp.Generalpractitioner.controller.dto.DocumentDTO;
import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Document;
import com.gp.Generalpractitioner.model.Patient;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class DocumentUtil {

	public Document convertDocumentDTOtoDocument(DocumentDTO documentDTO) {
		Document document = new Document();
		Patient patient = new Patient();
		patient.setSocialSecurityNumber(documentDTO.getSocialSecurityNumber());
		document.setSocialSecurityNumber(patient);
		document.setTitle(documentDTO.getTitle());
		document.setDiet(documentDTO.isDiet());
		document.setDietDescription(documentDTO.getDietDescription());
		document.setPsychiatricDisorder(documentDTO.isPsychiatricDisorder());
		document.setDisability(documentDTO.isDisability());
		document.setDisabilityDescription(documentDTO.getDisabilityDescription());
		document.setInfectiousDisease(documentDTO.isInfectiousDisease());
		document.setNote(documentDTO.getNote());
		document.setDate(documentDTO.getDate());
		document.setFileName(documentDTO.getFileName());
		return document;
	}

	public String generateFileName(DocumentDTO documentDTO) {
		return documentDTO.getSocialSecurityNumber() + documentDTO.getDate() + ".pdf";
	}

	public void createPdfDocument(DocumentDTO documentDTO, PatientDTO patientDTO) throws IOException {
		String path = "src/main/resources/static/admin/" + documentDTO.getFileName();
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);

		Paragraph paragraph = new Paragraph();
		paragraph.add(documentDTO.getTitle()).setTextAlignment(TextAlignment.CENTER).setItalic().setBold();

		float colWidth[] = { 100, 280 };
		Table patientTable = new Table(colWidth);

		patientTable.addCell(new Cell().add("Név: ").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(new Cell().add(patientDTO.getLastName() + " " + patientDTO.getFirstName())
				.setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(new Cell().add("Születési idö:").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(new Cell().add(new DateUtil().replaceHyphenDate(patientDTO.getDateOfBirth()))
				.setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(
				new Cell().add("Társadalombiztosítási Azonosító Jel:").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(
				new Cell().add(patientDTO.getSocialSecurityNumber()).setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(new Cell().add("Speciális diétára szorul-e:").setBorder(Border.NO_BORDER).setMargin(5f));

		if (documentDTO.isDiet()) {
			patientTable.addCell(new Cell().add("igen").setBorder(Border.NO_BORDER).setMargin(5f));
		} else {
			patientTable.addCell(new Cell().add("nem").setBorder(Border.NO_BORDER).setMargin(5f));
		}

		patientTable.addCell(new Cell().add("Ha igen milyen:").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable
				.addCell(new Cell().add(documentDTO.getDietDescription()).setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(
				new Cell().add("Pszichiátriai megbetegedésben szenved-e:").setBorder(Border.NO_BORDER).setMargin(5f));

		if (documentDTO.isPsychiatricDisorder()) {
			patientTable.addCell(new Cell().add("igen").setBorder(Border.NO_BORDER).setMargin(5f));
		} else {
			patientTable.addCell(new Cell().add("nem").setBorder(Border.NO_BORDER).setMargin(5f));
		}

		patientTable.addCell(new Cell().add("Fogyatékosságban szenved-e:").setBorder(Border.NO_BORDER).setMargin(5f));

		if (documentDTO.isDisability()) {
			patientTable.addCell(new Cell().add("igen").setBorder(Border.NO_BORDER).setMargin(5f));
		} else {
			patientTable.addCell(new Cell().add("nem").setBorder(Border.NO_BORDER).setMargin(5f));
		}

		patientTable.addCell(new Cell().add("Ha igen: típusa, mértéke:").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(
				new Cell().add(documentDTO.getDisabilityDescription()).setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(
				new Cell().add("Szenved-e jelenleg, illetve szenvedett-e fertözö betegségben az elmúlt 6 hónapban:")
						.setBorder(Border.NO_BORDER).setMargin(5f));

		if (documentDTO.isInfectiousDisease()) {
			patientTable.addCell(new Cell().add("igen").setBorder(Border.NO_BORDER).setMargin(5f));
		} else {
			patientTable.addCell(new Cell().add("nem").setBorder(Border.NO_BORDER).setMargin(5f));
		}

		patientTable
				.addCell(new Cell().add("A háziorvos egyéb megjegyzései:").setBorder(Border.NO_BORDER).setMargin(5f));
		patientTable.addCell(new Cell().add(documentDTO.getNote()).setBorder(Border.NO_BORDER).setMargin(5f));

		Paragraph dateParagraph = new Paragraph();
		dateParagraph.add(new DateUtil().replaceHyphenDate(documentDTO.getDate())).setMargin(5f);

		Paragraph signParagraph = new Paragraph();
		signParagraph.add("Orvos aláírása").setTextAlignment(TextAlignment.RIGHT).setMargin(30f);

		document.add(paragraph);
		document.add(patientTable);
		document.add(dateParagraph);
		document.add(signParagraph);

		document.close();
	}

}
