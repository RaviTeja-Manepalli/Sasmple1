package com.mindtree.passport.service;

import com.mindtree.passport.dao.DAO;
import com.mindtree.passport.dao.DAOService;
import com.mindtree.passport.entity.Passport;
import com.mindtree.passport.entity.Person;
import com.mindtree.passport.exception.DAOException.DAOException;
import com.mindtree.passport.exception.ServiceException.ServiceException;

public class ServiceImpl implements Service {
	static DAO dao = new DAOService();

	@Override
	public boolean displayPersonDetails(String personId) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = dao.displayPersondetailsDB(personId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean sortonBirthPlace() throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = dao.displaySortonPlaceDB();
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean checkIdPresent(String personId) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = dao.checkPersonDB(personId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public Person insertPersoninDB(String personId, String personName, String birthPlace, int age)
			throws ServiceException {
		// TODO Auto-generated method stub
		Person p = null;
		try {
			p = dao.storePersonDB(personId, personName, birthPlace, age);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return p;
	}

	@Override
	public Passport insertPassportinDB(String personId, String passNum, String passId) throws ServiceException {
		// TODO Auto-generated method stub
		Passport p = null;
		try {
			p = dao.storePassportDB(personId, passNum, passId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return p;
	}

}
