package com.example.example;

import com.vaadin.ui.VerticalSplitPanel;

public class ListView extends VerticalSplitPanel {
	public ListView(PersonList personList, PersonForm personForm) {
		setFirstComponent(personList);
		setSecondComponent(personForm);
		setSplitPosition(40);
	}
}
