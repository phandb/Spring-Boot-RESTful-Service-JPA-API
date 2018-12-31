package com.javaprojects.springboot.patientapp.dao;

import java.util.List;

import com.javaprojects.springboot.patientapp.entity.Patient;

public interface PatientDAO {

	//
	public List<Patient> getAllPatient();
	
	public Patient getPatientById(int patientId);
	
	public void savePatient(Patient thePatient);
	
	public void deletePatientById(int patientId);
}
