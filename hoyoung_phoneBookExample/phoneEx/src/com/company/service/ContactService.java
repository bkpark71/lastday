package com.company.service;

import java.util.HashMap;

import com.company.domain.Contact;
import com.company.exception.HasNoName;
import com.company.exception.NotUniqueName;
import com.company.repository.PhoneDB;

public class ContactService {
	public void save(Contact contact) throws NotUniqueName{
		try {
			PhoneDB.addContact(contact);
		} catch (NotUniqueName e) {
			throw new NotUniqueName();
		}
	}
	public void delete(String name) throws HasNoName {
		try {
			PhoneDB.deleteContactByName(name);
		} catch (HasNoName e) {
			throw new HasNoName();
		}
	}

	public Contact find(String name) throws HasNoName {
		try {
			return PhoneDB.findByName(name);
		} catch (HasNoName e) {
			throw new HasNoName();
		}
	}

	public HashMap<String, Contact> findAll() {
		return PhoneDB.findAll();
	}
}
