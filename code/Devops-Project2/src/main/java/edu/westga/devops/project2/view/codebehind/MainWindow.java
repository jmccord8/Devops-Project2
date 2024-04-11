package edu.westga.devops.project2.view.codebehind;

import edu.westga.devops.project2.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainWindow {

    @FXML
    private Button addItemButton;

    @FXML
    private Button editItemButton;

    @FXML
    private ListView<Item> itemListView;

    @FXML
    private Button removeItemButton;
    
    @FXML
    void initialize() {
        assert addItemButton != null : "fx:id=\"addItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert editItemButton != null : "fx:id=\"editItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert itemListView != null : "fx:id=\"itemListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert removeItemButton != null : "fx:id=\"removeItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
    
//    @FXML
//    void addItem(ActionEvent event) {
//
//    }

}
