package com.phone;
/*
 Write a program to simulate the actions of a phonebook.
Your program should be able to :
Add new entries 
Search for an existing entry
Search by first name *
Search by last name *
Search by full name *note name is not unique therefore the result should be an array of Person Objects.
Search by telephone number
Search by city or state
Delete a record for a given telephone number
Update a record for a given telephone number
Show all records in asc order
An option to exit the program 
Your program should operate on the console. It should display all the choices when the program loads. Eg 1. Add new record
    2. Delete a record
               Etc.. where 1 representing the action for adding a record and 2 representing the action
               for deleting a record.
Your program should run until the user selects the exit option. 
Your program should have a minimum of 2 classes a Person class, an Address  class.

Test case :
John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375

Searching for John should return a list of all 3 records above, displaying the telephone number in this order (636)-453-8563.

Optional add additional features to your program, for storing cell, home, work and fax numbers. 
Also features for storing events like birthday, anniversary, email… etc   
 */
import java.util.Arrays;
/*Simon Mwangi
 * Phone book project
 * Allows you to Add new record, delete a record using phone number and search for record via names. city state or phone number 
 * */
import java.util.Scanner;

public class Application {
	static Scanner input = new Scanner(System.in);
	static Contact[] arrayContacts;
	static Contact newContact;
	static int choice;
	static String firstName, middleName, lastName, street, city, state, zip, phoneNum;

	public static void main(String[] args) {

		startProgram();
	}

	// Start and run program
	public static void startProgram() {
		// firstName, middleName, lastName, phoneNum, street, city, state, zip

		int option1;
		// loop till choice is 0
		do {
			System.out.println();
			option1 = optionsMenu();
			switch (option1) {
			case 1:
				// Create new contact
				// System.out.println(input.next()());
				input.nextLine();
				System.out.println("Please Enter First Name");
				firstName = input.nextLine();
				System.out.println("Please Enter Middle Name");
				middleName = input.nextLine();
				System.out.println("Please Enter Last Name");
				lastName = input.nextLine();
				System.out.println("Please Enter Phone Number");
				phoneNum = input.next();
				input.nextLine();
				System.out.println("Please Enter Street Address");
				street = input.nextLine();
				// input.nextLine();
				System.out.println("Please Enter City");
				city = input.nextLine();
				System.out.println("Please Enter State");
				state = input.next();
				System.out.println("Please Enter ZipCode");
				zip = input.next();
				// firstName, lastName, cell,street,city,state,zip
				createContact(firstName, middleName, lastName, phoneNum, street, city, state, zip);

				break;
			case 2:
				int option = searchMenu();
				input.nextLine();
				System.out.println("Type it below..");

				String mySearch = input.nextLine();

				searchForContact(mySearch, option);

				break;
			case 3:
				// delete contatcs
				System.out.println("Enter Phone number to delete");
				String cellnumb = input.next();
				
				int index = searchNumb(cellnumb);
				if (index >= 0) {
					deleteContact(index);
					System.out.println("contact deleted");
				}

				break;
			case 4:
				// display all contacts
				if (arrayContacts != null) {
					for (int i = 0; i < arrayContacts.length; i++) {
						printContact(i);
					}
				} else {

					System.out.println("Sorry no contacts found");
				}
				break;
			case 5:
				// Update Record
				System.out.println("Enter Phone number to Update");
				String cellToUpdate = input.next();
				int index1 = searchNumb(cellToUpdate);

				if (index1 >= 0) {
					int optionOne = updateMenu();
					System.out.println("Type new record below");
					input.nextLine();
					String updatename = input.nextLine();
					updateRecord(index1, optionOne, updatename);

				}

				break;
			case 6:
				sort();

				break;
			default:

			}

		} while (option1 != 0);

		System.out.println("Good Bye: program Terminated");

	}

	// search phone number and return idex number
	private static int searchNumb(String cellnumb) {
		int j = -1;
		for (int i = 0; i < arrayContacts.length; i++) {

			if (arrayContacts[i].getCell().equals(cellnumb)) {

				return j = i;

			}

		}
		return j;

	}

	// options menu
	public static int optionsMenu() {

		System.out.println("1: To create new Contact");
		System.out.println("2: Search for existing Entry");
		System.out.println("3: Delete Contact");
		System.out.println("4: Display All Contacts");
		System.out.println("5: Update Record");
		System.out.println("6: Sort Record");
		System.out.println("0 To Exit press.");
		int option = input.nextInt();
		return option;

	}

	// Display search menu
	public static int searchMenu() {

		System.out.println("1: Search By First Name");
		System.out.println("2: Search By Last Name");
		System.out.println("3: Search By State");
		System.out.println("4: Search By city");
		System.out.println("5: Search By Phone Number");
		choice = input.nextInt();

		return choice;

	}

	// update menu display
	public static int updateMenu() {

		System.out.println("1: Update First Name");
		System.out.println("2: Update Last Name");
		System.out.println("3: Update Street");
		System.out.println("4: Update city");
		System.out.println("5: Update Phone Number");
		choice = input.nextInt();

		return choice;

	}

	// search for contact by name
	public static void searchForContact(String name, int option) {

		name = name.toLowerCase();

		for (int i = 0; i < arrayContacts.length; i++) {
			switch (option) {
			case 1:
				if (arrayContacts[i].getFirstName().equals(name)) {
					printContact(i);
				}
				break;
			case 2:
				if (arrayContacts[i].getLastName().equals(name)) {
					printContact(i);
				}
				break;
			case 3:
				if (arrayContacts[i].address.getState().equals(name)) {
					printContact(i);
				}
				break;
			case 4:
				if (arrayContacts[i].address.getCity().equals(name)) {
					printContact(i);
				}
			case 5:
				if (arrayContacts[i].getCell().equals(name)) {
					printContact(i);
				}
				break;
			default:
			}// end switch
		}
	}

	// print contact
	public static void printContact(int s) {
		System.out.println(arrayContacts[s] + " " + arrayContacts[s].address);
	}

	// method to create new contact object and add it to array object
	public static void createContact(String firstName, String middle, String lastName, String cell, String street,
			String city, String state, String zip) {

		newContact = new Contact(firstName, middle, lastName, cell, street, city, state, zip);
		// add contact to array
		addContact(newContact);

	}

	// Add new contacts to array
	public static void addContact(Contact newContact) {
		if (arrayContacts == null) {
			arrayContacts = new Contact[1];
		} else {

			arrayContacts = expandArray(arrayContacts);
		}
		// Add new contacts at end of the array
		arrayContacts[arrayContacts.length - 1] = newContact;
	}

	// expand array, transfer content and return array with one empty spot at last
	// index.
	private static Contact[] expandArray(Contact[] arrayContacts) {
		Contact[] temp = new Contact[arrayContacts.length + 1];

		// for loop to transfer contact info to the new array
		for (int i = 0; i < arrayContacts.length; i++) {
			temp[i] = arrayContacts[i];
		}
		// return new array with an extra empty index at the end.
		return temp;
	}

	// delete contact
	public static void deleteContact(int delete) {
		// create array with one less item
		int count = 0;
		Contact[] temp = new Contact[arrayContacts.length - 1];
		int j = 0;
		// copy array content to array
		for (int i = 0; i < arrayContacts.length; i++) {
			if (i != delete) {
				temp[j] = arrayContacts[i];
				j++;
			}
		}

		arrayContacts = temp;
	}
//update record
	public static void updateRecord(int index, int caseChoice, String newrec) {
		// System.out.println("1: Update First Name");
		// System.out.println("2: Update Last Name");
		// System.out.println("3: Update State");
		// System.out.println("4: Update city");
		// System.out.println("5: Update Phone Number");

		switch (caseChoice) {
		case 1:
			arrayContacts[index].setFirstName(newrec);
			break;
		case 2:
			arrayContacts[index].setLastName(newrec);
			break;
		case 3:
			arrayContacts[index].address.setStreet(newrec);
			break;
		case 4:
			arrayContacts[index].address.setCity(newrec);
			break;
		case 5:
			arrayContacts[index].setCell(newrec);
			break;

		}

	}
//sort the record by ascending order
	public static void sort() {
		Contact[] temp = new Contact[1];

		for (int i = 0; i < arrayContacts.length; i++) {
			for (int j = i + 1; j < arrayContacts.length; j++) {
				if(arrayContacts[i].getFirstName().compareTo(arrayContacts[j].getFirstName())>0) {
					temp[0] = arrayContacts[i];
					arrayContacts[i] = arrayContacts[j];
					arrayContacts[j] = temp[0];
					
				}
				
				/*
				 //second sort
				if (arrayContacts[i].getFirstName().charAt(0) < arrayContacts[j].getFirstName().charAt(0)) {

				} else {
					temp[0] = arrayContacts[i];
					arrayContacts[i] = arrayContacts[j];
					arrayContacts[j] = temp[0];
				}
				*/
			}
		}
	}

}
