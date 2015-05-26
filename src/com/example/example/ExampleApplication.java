package com.example.example;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Main application class.
 */
public class ExampleApplication extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		buildMainLayout();
	}
	
	private NavigationTree tree = new NavigationTree();
	private Button newContact = new Button("Add contact");
	private Button search = new Button("Search");
	private Button share = new Button("Share");
	private Button help = new Button("Help");
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();

	private void buildMainLayout() {
		setMainWindow(new Window("Address Book Demo application"));
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.addComponent(createToolbar());
		layout.addComponent(horizontalSplit);
		/* Allocate all available extra space to the horizontal split panel */
		layout.setExpandRatio(horizontalSplit, 1);
		/*
		 * Set the initial split position so we can have a 200 pixel menu to the
		 * left
		 */
		horizontalSplit.setFirstComponent(tree);
		horizontalSplit.setSplitPosition(200, HorizontalSplitPanel.UNITS_PIXELS);
		horizontalSplit.setSecondComponent(getListView());
		getMainWindow().setContent(layout);
	}

	public HorizontalLayout createToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
		lo.addComponent(newContact);
		lo.addComponent(search);
		lo.addComponent(share);
		lo.addComponent(help);
		return lo;
	}

	private ListView listView = null;
	private PersonList personList = null;
	private PersonForm personForm = null;
	
	private ListView getListView() {
		if (listView == null) {
			personList = new PersonList();
			personForm = new PersonForm();
			listView = new ListView(personList, personForm);
		}
		return listView;
	}
}