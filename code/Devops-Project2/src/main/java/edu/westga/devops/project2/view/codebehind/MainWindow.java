package edu.westga.devops.project2.view.codebehind;

import java.util.InputMismatchException;
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
		this.itemListView.refresh();
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

	@FXML
	void editItem() {
		try {
			Item selectedItem = this.itemListView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				TextInputDialog itemDialog = new TextInputDialog();
				itemDialog.setTitle("Edit Quantity");
				itemDialog.setHeaderText("Enter the item quantity");
				itemDialog.setContentText("Quantity:");
				Optional<String> result = itemDialog.showAndWait();
				if (result.isPresent()) {
					selectedItem.setQuantity(Integer.valueOf(result.get()));
					this.refreshItemListView();
				}
			} else {
				throw new Exception();
			}
		} catch (InputMismatchException ex) {
			this.displayError("Quantity must be an integer value greater than 0.");
		} catch (IllegalArgumentException ex) {
			this.displayError(ex.getMessage());
		} catch (Exception ex) {
			this.displayError("No item was selected. Please select a item before clicking the edit button.");
		}
	}

	@FXML
	void removeItem() {
		try {
			Item selectedItem = this.itemListView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				itemManager.removeItem(selectedItem);
			} else {
				throw new Exception();
			}
			this.refreshItemListView();
		} catch (IllegalArgumentException ex) {
			this.displayError(ex.getMessage());
		} catch (Exception ex) {
			this.displayError("No item was selected. Please select a item before clicking the remove button.");
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
