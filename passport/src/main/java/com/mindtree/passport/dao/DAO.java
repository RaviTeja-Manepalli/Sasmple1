package com.mindtree.passport.dao;

import com.mindtree.passport.entity.Passport;
import com.mindtree.passport.entity.Person;

public interface DAO {
	public Person storePersonDB(String personId, String personName, String birthPlace, int age) throws Exception;

	public Passport storePassportDB(String personId, String passNum, String passId) throws Exception;

	public boolean displayPersondetailsDB(String personId) throws Exception;

	public boolean displaySortonPlaceDB() throws Exception;

	public boolean checkPersonDB(String personId) throws Exception;

}
