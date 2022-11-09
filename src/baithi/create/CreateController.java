package baithi.create;

import baithi.Main;
import baithi.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;
    public static ObservableList<Student> listStudent = FXCollections.observableArrayList();
    public Text error;

    public void create(ActionEvent actionEvent) {
        try{
            error.setVisible(false);
            if(txtId.getText().isEmpty()||txtName.getText().isEmpty()||txtAddress.getText().isEmpty()||txtPhone.getText().isEmpty()){
                throw new Exception("Vui lòng nhập đầy đủ thông tin sinh viên");
            }
            Student st = new Student(txtId.getText(),txtName.getText(),txtAddress.getText(),txtPhone.getText());
            listStudent.add(st);
            goToList(null);
        }catch (Exception e){
            error.setVisible(true);
            error.setText(e.getMessage());
        }
    }

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent home = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.bStage.setScene(new Scene(home,Main.width,Main.height));

    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent list = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.bStage.setScene(new Scene(list,Main.width,Main.height));
    }
}
