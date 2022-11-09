package baithi.list;

import baithi.Main;
import baithi.Student;
import baithi.create.CreateController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableView<Student> tdList;
    public TableColumn<Student,String> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdAddress;
    public TableColumn<Student,String> tdPhone;



    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent home = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.bStage.setScene(new Scene(home,Main.width,Main.height));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tdAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tdPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tdList.setItems(CreateController.listStudent);
    }
}
