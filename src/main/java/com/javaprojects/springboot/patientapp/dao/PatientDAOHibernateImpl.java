package com.javaprojects.springboot.patientapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaprojects.springboot.patientapp.entity.Patient;

@Repository
public class PatientDAOHibernateImpl implements PatientDAO {

	//Define field for enrity manager
	private EntityManager entityManager;
	
	//Set up constructor injector
	@Autowired
	public PatientDAOHibernateImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

}
