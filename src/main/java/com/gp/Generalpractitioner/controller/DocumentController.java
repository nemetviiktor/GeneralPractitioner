package com.gp.Generalpractitioner.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.DocumentDTO;
import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Patient;
import com.gp.Generalpractitioner.service.DateUtil;
import com.gp.Generalpractitioner.service.DocumentService;
import com.gp.Generalpractitioner.service.DocumentUtil;
import com.gp.Generalpractitioner.service.PatientService;
import com.gp.Generalpractitioner.service.PatientUtil;

@Controller
public class DocumentController {

	private DocumentService documentService;
	private PatientService patientService;

	@Autowired
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	@RequestMapping(value = "admin/documents")
	public ModelAndView findPatient() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientDTO", new PatientDTO());
		mav.setViewName("adminDocuments");
		return mav;
	}

	@RequestMapping(value = "admin/findPatientBySocialSecurityNumber")
	public ModelAndView showPatientBySocialSecurityNumber(@ModelAttribute("patientDTO") PatientDTO patientDTO) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient", patientService.findBySocialSecurityNumber(patientDTO.getSocialSecurityNumber()));
		Patient patient = new Patient();
		patient.setSocialSecurityNumber(patientDTO.getSocialSecurityNumber());
		mav.addObject("documents", documentService.findDocumentsBySocialSecurityNumber(patient));
		mav.setViewName("adminListDocuments");
		return mav;
	}

	@RequestMapping(value = "admin/newDocument")
	public ModelAndView createNewDocument(@ModelAttribute("patientDTO") PatientDTO patientDTO,
			@RequestParam String socialSecurityNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientDTO", patientService.findBySocialSecurityNumber(socialSecurityNumber));

		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setSocialSecurityNumber(socialSecurityNumber);
		mav.addObject("documentDTO", documentDTO);
		mav.setViewName("adminCreateNewDocument");
		return mav;
	}

	@PostMapping("/createDocument")
	public ModelAndView createDocument(@Valid @ModelAttribute("documentDTO") DocumentDTO documentDTO,
			BindingResult bindingResult, @ModelAttribute("patientDTO") PatientDTO patientDTO,
			@RequestParam String socialSecurityNumber) throws IOException {

		if (!bindingResult.hasErrors()) {
			documentDTO.setSocialSecurityNumber(socialSecurityNumber);
			documentDTO.setDate(new DateUtil().getCurrentDate());
			documentDTO.setFileName(new DocumentUtil().generateFileName(documentDTO));
			documentService.saveDocument(documentDTO);
			Patient patient = new Patient();
			patient = patientService.findBySocialSecurityNumber(socialSecurityNumber);
			patientDTO = new PatientUtil().convertPatientToPatientDTO(patient);
			new DocumentUtil().createPdfDocument(documentDTO, patientDTO);

			return new ModelAndView("redirect:/admin/documents");
		}

		return new ModelAndView("adminCreateNewDocument").addObject("documentDTO", documentDTO)
				.addObject("patientDTO", patientService.findBySocialSecurityNumber(socialSecurityNumber))
				.addObject(socialSecurityNumber);
	}
}
