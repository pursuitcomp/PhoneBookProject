package com.phone;

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
	static String firstName, lastName, street, city, state, zip, phoneNum;

	public static void main(String[] args) {
		String firstName, lastName, middle, street, city, state, zip, middleName;

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
				System.out.println("Enter Phone number to delete");
				String cellnumb = input.next();
				int index = searchNumb(cellnumb);
				if (index >= 0) {
					deleteContact(index);
					System.out.println("1 contact deleted");
				}

				break;
			case 4:
				if (arrayContacts != null) {
					for (int i = 0; i < arrayContacts.length; i++) {
						printContact(i);
					}
				} else {

					System.out.println("Sorry no contacts found");
				}
				// break;
			case 5:
				// break;
			case 6:
				// break;
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
		System.out.println("0 To Exit press.");
		int option = input.nextInt();
		return option;

	}

	// Display search menu
	public static int searchMenu() {

		System.out.println("1: Search by First Name");
		System.out.println("2: Search by Last Name");
		System.out.println("3: Search by State");
		System.out.println("4: Search by city");
		System.out.println("5: Search by Phone Number");
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
	// arrayContacts[s].getFirstName() +" "+ arrayContacts[s].getLastName() + " " +
	// arrayContacts[s].getCell() getStreet()+"
	// "+arrayContacts[s].address.getCity()+arrayContacts[s].address.getState()+arrayContacts[s].address.getZip()
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

}
