package edu.westga.devops.project2.view.codebehind;

import java.util.Optional;

import edu.westga.devops.project2.model.Item;
import edu.westga.devops.project2.model.ItemManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

public class MainWindow {

	@FXML
	private Button addItemButton;

	@FXML
	private Button editItemButton;

	@FXML
	private ListView<Item> itemListView;

	@FXML
	private Button removeItemButton;

	private static ItemManager itemManager;

	@FXML
	void initialize() {
		assert addItemButton != null
				: "fx:id=\"addItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert editItemButton != null
				: "fx:id=\"editItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert itemListView != null
				: "fx:id=\"itemListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert removeItemButton != null
				: "fx:id=\"removeItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

		if (itemManager == null) {
			itemManager = new ItemManager();
		}

		this.refreshItemListView();
	}

	private void refreshItemListView() {
		this.itemListView.setItems(itemManager.getItems());
	}

	@FXML
	void addItem() {
		try {
			TextInputDialog itemDialog = new TextInputDialog();
			itemDialog.setTitle("Add Item");
			itemDialog.setHeaderText("Enter an item name");
			itemDialog.setContentText("Name:");
			Optional<String> result = itemDialog.showAndWait();
			if (result.isPresent()) {
				Item item = new Item(result.get());
				itemManager.addItem(item);
				this.refreshItemListView();
			} else {
				this.displayError("Cannot add an item with an empty name.");
			}
		} catch (IllegalArgumentException ex) {
			this.displayError(ex.getMessage());
		}
	}

	private void displayError(String text) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}

}
