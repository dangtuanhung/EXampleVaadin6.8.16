package com.example.example;

import com.vaadin.ui.Table;

public class PersonList extends Table {
	public PersonList() {
		// create some dummy data
		addContainerProperty("First Name", String.class, "Mark");
		addContainerProperty("Last Name", String.class, "Smith");
		addItem();
		addItem();
		setSizeFull();
	}
}
