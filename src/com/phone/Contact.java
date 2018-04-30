package com.phone;

public class Contact {
private String firstName, lastName, email,middleName;
private String cell;

Address address;

public Contact(String firstName,String middleName, String lastName,String cell,String street, String city, String state, String zip) {
	
	this.firstName = firstName.toLowerCase();
	this.middleName=middleName.toLowerCase();
	this.lastName = lastName.toLowerCase();
	this.cell = cell;
	this.address=new Address(street,city,state,zip);
	//this.address = address;
}
//get first name
public String getFirstName() {
	return firstName;
}
//set first name
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
// get last name
public String getLastName() {
	return lastName;
}

//set last name
public void setLastName(String lastName) {
	this.lastName = lastName;
}
//get email
public String getEmail() {
	return email;
}
//set email
public void setEmail(String email) {
	this.email = email;
}
//get cell number
public String getCell() {
	return cell;
}
//set cell number
public void setCell(String cell) {
	this.cell = cell;
}

//get contacts address
public Address getAddress() {
	return address;
}

//set contact address
//Object address for each contact created
public void setAddress(int houseNum, String street, String city, String state, String zip) {
	
	//this.address=new Address(houseNum,street,city,state,zip);
	
	//this.address = address;
}

public String toString() {
	
	return  "Name: "+ this.firstName+" "+this.middleName+" "+this.lastName+" Cell: "+"("+this.cell.substring(0, 3)+")-"+this.cell.substring(3, 6)+"-"+this.cell.substring(6, 10);
}


}
