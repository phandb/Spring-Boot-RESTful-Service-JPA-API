package com.javaprojects.springboot.patientapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaprojects.springboot.patientapp.entity.Patient;

@Repository
public class PatientDAOHibernateImpl implements PatientDAO {

	//Define field for entity manager
	private EntityManager entityManager;
	
	//Set up constructor injection
	@Autowired
	public PatientDAOHibernateImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	@Override
	public List<Patient> getAllPatient() {


		//Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		Query<Patient> theQuery = currentSession.createQuery("from Patient", Patient.class);
		
		//Execute query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return the results
		
		return patients;
	}
	
	@Override
	public Patient getPatientById(int patientId) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the patient
		Patient thePatient = currentSession.get(Patient.class, patientId);
		
		//return the patient
		return thePatient;
	}
	
	@Override
	public void savePatient(Patient thePatient) {
		// get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save patient
		currentSession.saveOrUpdate(thePatient);
		
		
	}
	
	@Override
	public void deletePatientById(int theId) {
		// get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Patient where id=:patientId");
		
		theQuery.setParameter("patientId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
