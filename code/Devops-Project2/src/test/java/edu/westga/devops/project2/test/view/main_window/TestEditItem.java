package edu.westga.devops.project2.test.view.main_window;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; // Import OrderAnnotation

import edu.westga.devops.project2.Main;
import edu.westga.devops.project2.model.Item;

@TestMethodOrder(OrderAnnotation.class)
public class TestEditItem extends ApplicationTest {

	@Override
	public void start(Stage stage) throws IOException {
		(new Main()).start(stage);
	}

	@Test
	@Order(1)
	void editItem() {
		this.clickOn("#addItemButton");
		this.type(KeyCode.A);
		this.type(KeyCode.P);
		this.type(KeyCode.P);
		this.type(KeyCode.L);
		this.type(KeyCode.E);
		this.type(KeyCode.ENTER);

		ListView<Item> itemListView = lookup("#itemListView").query();

		Object firstItem = itemListView.getItems().get(0);

		this.clickOn(firstItem.toString());

		this.clickOn("#editItemButton");
		this.type(KeyCode.DIGIT5);
		this.type(KeyCode.ENTER);
		firstItem = itemListView.getItems().get(0);
		Assertions.assertEquals("apple (5)", firstItem.toString());
		FxAssert.verifyThat("#resultLabel", LabeledMatchers.hasText("apple quantity was updated to 5"));
	}

	@Test
	@Order(2)
	void editItemNoSelection() {
		this.clickOn("#editItemButton");

		Node dialogPane = lookup(".dialog-pane").query();

		Text noSelection = from(dialogPane).lookup((Text t) -> t.getText().startsWith("No item")).query();

		Assertions.assertNotNull(noSelection, "Dialog with text 'No item' not found");

		Assertions.assertEquals("No item was selected. Please select a item before clicking the edit button.",
				noSelection.getText());
	}
	
	@Test
	@Order(3)
	void editItemLessThan1() {
		
		ListView<Item> itemListView = lookup("#itemListView").query();

		Object firstItem = itemListView.getItems().get(0);

		this.clickOn(firstItem.toString());

		this.clickOn("#editItemButton");
		this.type(KeyCode.DIGIT0);
		this.type(KeyCode.ENTER);
		
		Node dialogPane = lookup(".dialog-pane").query();

		Text invalidQuantity = from(dialogPane).lookup((Text t) -> t.getText().startsWith("Quantity cannot")).query();

		Assertions.assertNotNull(invalidQuantity, "Dialog with text 'Quantity cannot' not found");

		Assertions.assertEquals("Quantity cannot be less than 1",
				invalidQuantity.getText());
	}
}
