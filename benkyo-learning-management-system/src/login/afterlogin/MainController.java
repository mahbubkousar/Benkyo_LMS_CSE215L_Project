/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login.afterlogin;



import java.io.IOException;
import login.afterlogin.Info;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane content;
    
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField tfFaculty;

    @FXML
    private TextField tfSerial;

    @FXML
    private TextField tfCredit;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSection;
    @FXML
    private TableView<Info> tvInfo;
    @FXML
    private TableColumn<Info, Integer> colSerial;
    @FXML
    private TableColumn<Info, String> colName;
    @FXML
    private TableColumn<Info, String> colFaculty;
    @FXML
    private TableColumn<Info, Integer> colSection;
    @FXML
    private TableColumn<Info, Integer> colCredit;

    @FXML
    private void handle_logout(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
        content.getChildren().removeAll();
        content.getChildren().setAll(menu);
    }
    
    @FXML
    void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btnInsert){
            insertRecord();
        } 
        else if(event.getSource() ==btnUpdate){
            updateRecord();
        } else if(event.getSource() ==btnDelete){
            deleteRecord();
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         showInfo ();
    }    
    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "mahbub@CSE221");
            return conn;
        } catch(Exception ex){
            System.out.println("Error: "+ex);
            return null;
        }
    }
        
    
    public ObservableList<Info> getInfoList(){
        ObservableList<Info> infoList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM info";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Info info;
            while(rs.next()){
                info = new Info(rs.getInt("serial"),  rs.getString("name"), rs.getString("faculty"), rs.getInt("section"), rs.getInt("credit"));
                infoList.add(info);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return infoList;
    }
    
       
    public void showInfo (){
         ObservableList<Info> list = getInfoList();
         
         colSerial.setCellValueFactory(new PropertyValueFactory<Info, Integer>("serial"));
         colName.setCellValueFactory(new PropertyValueFactory<Info, String>("name"));
         colFaculty.setCellValueFactory(new PropertyValueFactory<Info, String>("faculty"));
         colSection.setCellValueFactory(new PropertyValueFactory<Info, Integer>("section"));
         colCredit.setCellValueFactory(new PropertyValueFactory<Info, Integer>("credit"));
         
         tvInfo.setItems(list);
         
    }
    
    
    private void insertRecord(){
        String query = "INSERT INTO info VALUES (" + tfSerial.getText() + ",'" + tfName.getText() + "','" + tfFaculty.getText() + "'," + tfSection.getText() + "," + tfCredit.getText() + ")";
        
        executeQuery(query);
        showInfo ();
    }

    private void updateRecord(){
        String query = "UPDATE info SET name = '" + tfName.getText() + "', faculty = '" + tfFaculty.getText() + "', section = " + tfSection.getText() + ", credit = " + tfCredit.getText() + " WHERE serial = " + tfSerial.getText() + "";
        executeQuery(query);
        showInfo ();
    }
    
    private void deleteRecord(){
        String query = "DELETE FROM info WHERE serial = " + tfSerial.getText() + "";
        executeQuery(query);
        showInfo ();
    }
    
    
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception ex){
            ex.fillInStackTrace();
        }
    }
    
}
