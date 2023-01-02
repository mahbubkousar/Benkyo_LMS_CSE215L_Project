
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Pane content;
        @FXML
    private TextField loginID;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label wrongpass;
    
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handel_login(ActionEvent event) throws IOException {
        if((loginID.getText().equals("mahbub") || loginID.getText().equals("sifat")  || loginID.getText().equals("rayeed")  || loginID.getText().equals("sarkar")) && loginPassword.getText().equals("1234") ){
            wrongpass.setText(" ");
            Parent main = FXMLLoader.load(getClass().getResource("/login/afterlogin/Main.fxml"));
        content.getChildren().removeAll();
        content.getChildren().setAll(main);
        }
        else{
            wrongpass.setText("Wrong UserID or Password! Try again!!!");
            loginID.setText("");
            loginPassword.setText("");
                    
        }
        
    }
    
}
