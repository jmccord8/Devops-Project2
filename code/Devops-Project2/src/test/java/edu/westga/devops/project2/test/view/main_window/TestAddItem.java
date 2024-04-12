package edu.westga.devops.project2.test.view.main_window;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;

import edu.westga.devops.project2.Main;

public class TestAddItem extends ApplicationTest {

	@Override
	public void start(Stage stage) throws IOException {
		(new Main()).start(stage);
	}

	@Test
	void addItem() {
		this.clickOn("#addItemButton");
		this.type(KeyCode.A);
		this.type(KeyCode.P);
		this.type(KeyCode.P);
		this.type(KeyCode.L);
		this.type(KeyCode.E);
		this.type(KeyCode.ENTER);

		FxAssert.verifyThat("#resultLabel", LabeledMatchers.hasText("Item was successfully added"));
	}
	
	@Test
	void addItemEmptyName() {
		this.clickOn("#addItemButton");
		this.type(KeyCode.ENTER);
		
	    Node dialogPane = lookup(".dialog-pane").query();

	    Text emptyName = from(dialogPane).lookup((Text t) -> t.getText().startsWith("Name cannot")).query();

	    Assertions.assertNotNull(emptyName, "Dialog with text 'Name cannot' not found");
	    
	    Assertions.assertEquals("Name cannot be empty", emptyName.getText());
	}
}
