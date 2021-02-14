package com.mindtree.passport.service;

import com.mindtree.passport.entity.Passport;
import com.mindtree.passport.entity.Person;
import com.mindtree.passport.exception.ServiceException.ServiceException;

public interface Service {
	public Person insertPersoninDB(String personId, String personName, String birthPlace, int age) throws ServiceException;

	public Passport insertPassportinDB(String personId, String passNum, String passId) throws ServiceException;

	public boolean displayPersonDetails(String personId) throws ServiceException;

	public boolean sortonBirthPlace() throws ServiceException;

	public boolean checkIdPresent(String personId) throws ServiceException;

}
