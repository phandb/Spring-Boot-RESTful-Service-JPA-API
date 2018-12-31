package com.javaprojects.springboot.patientapp.service;

import java.util.List;

import com.javaprojects.springboot.patientapp.entity.Patient;

public interface PatientService {
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(int theId);
	
	public void savePatient(Patient thePatient);
	
	public void deletePatientById(int theId);
	

}
