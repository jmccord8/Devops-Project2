package edu.westga.devops.project2.model;

//import edu.westga.comp4420.javafx_sample.model.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemManager {
	private ObservableList<Item> items;
	private static final String NULL_ITEM = "Item cannot be null";

	public ItemManager() {
		this.items = FXCollections.observableArrayList();
	}

	public ObservableList<Item> getItems() {
		return this.items;
	}
}
