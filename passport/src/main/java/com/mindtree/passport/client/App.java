package com.mindtree.passport.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.passport.entity.Passport;
import com.mindtree.passport.entity.Person;
import com.mindtree.passport.exception.NoSuchPersonException;
import com.mindtree.passport.exception.PassportException;
import com.mindtree.passport.exception.ServiceException.ServiceException;
/*import com.mindtree.school.Exceptions.NoSuchSchoolException;
import com.mindtree.school.Exceptions.SchoolException;
import com.mindtree.school.entity.School;
import com.mindtree.school.entity.Student;*/
import com.mindtree.passport.service.Service;
import com.mindtree.passport.service.ServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner sc = new Scanner(System.in);
	static Service service = new ServiceImpl();

	public static void main(String[] args) throws Exception {

		List<Person> person = new ArrayList<Person>();
		int choice = 0;
		do {
			System.out.println("-------------------------------------------\n" + "1-->create person \n"
					+ "2-->create passport\n" + "3-->display details of a person\n" + "4--> sort by birthplace \n"
					+ "5-->exit\n" + "-------------------------------------------");
			System.out.println("Enter ur choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("enter person Id");
				String personId = sc.nextLine();
				boolean check = service.checkIdPresent(personId);
				boolean res = false;
				if (check == false) {
					person.add(createPerson(personId));

				}

				break;
			case 2:
				System.out.println("Enter personId");
				sc.nextLine();
				String personId1 = sc.nextLine();
				boolean check1 = service.checkIdPresent(personId1);
				System.out.println(check1);
				if (check1 == true) {
					for (Person val : person) {
						if (val.getId().equals(personId1)) {
							Passport p = null;
							try {
								p = createPassport(personId1);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							val.setPass(p);
							;
							break;
						}
					}
				}
				break;
			case 3:
				boolean res2 = false;
				sc.nextLine();
				System.out.println("Enter person id");
				String personId2 = sc.nextLine();
				try {
					res2 = service.displayPersonDetails(personId2);
				} catch (NoSuchPersonException e) {
					System.out.println("No person is present");
				}
				if (res2 == false) {
					System.out.println("No Details in  DB");
				}

				break;
			case 4:
				boolean res1 = false;
				try {
					res1 = service.sortonBirthPlace();
				} catch (NoSuchPersonException e) {
					System.out.println("No person is present");
				}
				if (res1 == false) {
					System.out.println("No Details in  DB");
				}
				break;
			case 5:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid input");
			}
		} while (choice != 5);
	}

	private static Person createPerson(String personId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter name");
		String personName = sc.nextLine();
		System.out.println("Enter Birthplace");
		String birthPlace = sc.nextLine();
		System.out.println("Enter age");
		int age = sc.nextInt();
		Person p = null;
		try {
			p = service.insertPersoninDB(personId, personName, birthPlace, age);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to insert into DB");
		}
		return p;
	}

	private static Passport createPassport(String personId) throws PassportException {
		// TODO Auto-generated method stub
		System.out.println("Enter password Number");
		String passNum = sc.nextLine();
		System.out.println("Enter password Id");
		String passId = sc.nextLine();
		Passport p = null;
		try {
			p = service.insertPassportinDB(personId, passNum, passId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to insert");
		}
		return p;
	}

}
