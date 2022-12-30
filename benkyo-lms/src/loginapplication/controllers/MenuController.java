
package loginapplication.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable {

    @FXML
    private AnchorPane content;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_logout(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("/loginapplication/views/Login.fxml"));
        content.getChildren().removeAll();
        content.getChildren().setAll(menu);
    }
    
}
