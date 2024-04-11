package edu.westga.devops.project2.model;

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

	public void addItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException(NULL_ITEM);
		}
		this.items.add(item);
	}

	public void removeItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException(NULL_ITEM);
		}
		this.items.remove(item);
	}

	public int getSize() {
		return this.items.size();
	}
}
