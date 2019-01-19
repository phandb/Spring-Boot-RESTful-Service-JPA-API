package com.javaprojects.springboot.patientapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaprojects.springboot.patientapp.entity.Patient;

@Repository
public class PatientDAOJpaImpl implements PatientDAO {
	
	//Define field for entity manager
	private EntityManager entityManager;
	
	//set up construction injection
	@Autowired
	public PatientDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	
	

	@Override
	public List<Patient> findAll() {
		
		// Create query
		Query theQuery = entityManager.createQuery("from Patient");
		
		//Execute query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return result list
		return patients;
	}

	@Override
	public Patient findById(int patientId) {

		//get the patient
		
		Patient thePatient = entityManager.find(Patient.class,patientId);
		
		
		//return the patient
		return thePatient;
	}

	@Override
	public void save(Patient thePatient) {

		//Save or update the patient
		Patient dbPatient = entityManager.merge(thePatient);
		
		//update patient with id from db...so we can get generated id for save/insert
		thePatient.setId(dbPatient.getId() );

	}

	@Override
	public void deleteById(int patientId) {
		
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Patient where id=:patientId");
		
		//set parameter
		theQuery.setParameter(patientId, patientId);
		
		//execute
		theQuery.executeUpdate();
		
	}

}
