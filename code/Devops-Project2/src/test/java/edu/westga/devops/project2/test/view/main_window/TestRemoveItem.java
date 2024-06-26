package edu.westga.devops.project2.test.view.main_window;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;

import edu.westga.devops.project2.Main;
import edu.westga.devops.project2.model.Item;

public class TestRemoveItem extends ApplicationTest {

	@Override
	public void start(Stage stage) throws IOException {
		(new Main()).start(stage);
	}

	@Test
	void removeItem() {
		this.clickOn("#addItemButton");
		this.type(KeyCode.A);
		this.type(KeyCode.P);
		this.type(KeyCode.P);
		this.type(KeyCode.L);
		this.type(KeyCode.E);
		this.type(KeyCode.ENTER);

		this.clickOn("#addItemButton");
		this.type(KeyCode.G);
		this.type(KeyCode.R);
		this.type(KeyCode.A);
		this.type(KeyCode.P);
		this.type(KeyCode.E);
		this.type(KeyCode.ENTER);

		ListView<Item> itemListView = lookup("#itemListView").query();

		Object firstItem = itemListView.getItems().get(0);
		Assertions.assertEquals("apple (5)", firstItem.toString());

		this.clickOn(firstItem.toString());
		this.clickOn("#removeItemButton");

		firstItem = itemListView.getItems().get(0);
		Assertions.assertEquals("apple", firstItem.toString());
		FxAssert.verifyThat("#resultLabel", LabeledMatchers.hasText("apple was removed"));
	}

	@Test
	void removeItemNoSelection() {
		this.clickOn("#removeItemButton");

		Node dialogPane = lookup(".dialog-pane").query();

		Text noSelection = from(dialogPane).lookup((Text t) -> t.getText().startsWith("No item")).query();

		Assertions.assertNotNull(noSelection, "Dialog with text 'No item' not found");

		Assertions.assertEquals("No item was selected. Please select a item before clicking the remove button.",
				noSelection.getText());
	}
}
