package com.company.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.company.domain.Contact;
import com.company.exception.HasNoName;
import com.company.exception.NotUniqueName;

public class PhoneDB {
	private static PhoneDB instance;
	private static HashMap<String, Contact> db = new LinkedHashMap<>();
	private PhoneDB() {};

	public static PhoneDB getInstance() {
		if (instance == null) {
			instance = new PhoneDB();
		}
		return instance;
	}

	public static void addContact(Contact contact) throws NotUniqueName {
		if (db.containsKey(contact.getName())) throw new NotUniqueName();
		db.put(contact.getName(), contact);
	}
	public static void deleteContactByName(String name) throws HasNoName {
		if (!db.containsKey(name)) throw new HasNoName();
		db.remove(name);
	}

	public static Contact findByName(String name) throws HasNoName {
		if (!db.containsKey(name)) throw new HasNoName();
		return db.get(name);
	}

	public static HashMap<String, Contact> findAll() {
		return db;
	}
}
