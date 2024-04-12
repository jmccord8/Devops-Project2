package edu.westga.devops.project2.test.view.main_window;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.TextInputControlMatchers;

import edu.westga.devops.project2.Main;
import edu.westga.devops.project2.view.codebehind.MainWindow;

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
		
		FxAssert.verifyThat("#itemListView", TextInputControlMatchers.hasText("Apple"));
	}
}
