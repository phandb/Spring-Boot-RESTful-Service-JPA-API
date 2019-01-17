package com.javaprojects.springboot.patientapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaprojects.springboot.patientapp.dao.PatientDAO;
import com.javaprojects.springboot.patientapp.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	private PatientDAO patientDAO;
	
	//Setup Contructor Injection
	@Autowired
	public PatientServiceImpl(PatientDAO thePatientDAO) {
		
		patientDAO = thePatientDAO;
	}

	@Override
	@Transactional
	public List<Patient> getAllPatients() {
		
		return patientDAO.getAllPatient();
	}

	@Override
	@Transactional
	public Patient getPatientById(int theId) {
		
		return patientDAO.getPatientById(theId);
	}

	@Override
	@Transactional
	public void savePatient(Patient thePatient) {

		patientDAO.savePatient(thePatient);

	}

	@Override
	@Transactional
	public void deletePatientById(int theId) {

		patientDAO.deletePatientById(theId);

	}

}
