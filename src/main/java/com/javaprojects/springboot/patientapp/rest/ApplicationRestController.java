package com.javaprojects.springboot.patientapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojects.springboot.patientapp.entity.Patient;
import com.javaprojects.springboot.patientapp.service.PatientService;

@RestController
@RequestMapping("/spring-boot-pms")
public class ApplicationRestController {
	
	private PatientService patientService;
	
	//Inject patient dao using constructor injection
	@Autowired
	public ApplicationRestController(PatientService thePatientService) {
		
		patientService = thePatientService;
	}
	
	//expose "/patients" and return list of patients
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		
		return patientService.getAllPatients();
	}
	
	//Return particular patient using id
	@GetMapping("patients/{patientId}")
	public Patient getPatientById(@PathVariable int patientId) {
		
		Patient thePatient = patientService.getPatientById(patientId);
		
		if (thePatient == null) {
			throw new RuntimeException("Patinet id not found: " + patientId);
		}
		
		return thePatient;

	}
	
	//add mapping for POST /patients to add new patient
	
	@PostMapping("/patients")
	public Patient addNewPatient(@RequestBody Patient thePatient) {
		
		//Just in case they pass an id in JSON....set id to 0
		//This is to force a save of new item.. instead of update
		
		thePatient.setId(0);
		
		patientService.savePatient(thePatient);
		
		return thePatient;
	}
	
	//Mapping PUT /patients to update patient object
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.savePatient(thePatient);
		
		return thePatient;
	}
	
	//Mapping DELETE /patients{patientId} to delete a patient with id
	@DeleteMapping("patient/{patientId}")
	public String deletePatient(@PathVariable int patientId) {
		
		Patient tempPatient =  patientService.getPatientById(patientId);
		
		//throw exception if null
		
		if (tempPatient == null) {
			throw new RuntimeException("Patient id not found: " + patientId);
		}
		
		patientService.deletePatientById(patientId);
		return "Delete patient id - " + patientId;
	}
	
	
	
}
