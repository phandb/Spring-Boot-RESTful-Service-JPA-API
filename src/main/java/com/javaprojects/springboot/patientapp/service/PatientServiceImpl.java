package com.javaprojects.springboot.patientapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaprojects.springboot.patientapp.dao.PatientDAO;
import com.javaprojects.springboot.patientapp.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	private PatientDAO patientDAO;
	
	//Setup Contructor Injection
	@Autowired
	public PatientServiceImpl(@Qualifier("patientDAOJpaImpl") PatientDAO thePatientDAO) {
		
		patientDAO = thePatientDAO;
	}

	@Override
	@Transactional
	public List<Patient> findAll() {
		
		return patientDAO.findAll();
	}

	@Override
	@Transactional
	public Patient findById(int theId) {
		
		return patientDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Patient thePatient) {

		patientDAO.save(thePatient);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		patientDAO.deleteById(theId);

	}

}
