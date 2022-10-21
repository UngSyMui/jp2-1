package library.student.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import library.Main;
import library.dao.impls.StudentRepository;
import library.entities.Student;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentEditController implements Initializable {
    public TextField txtName;
    public TextField txtTel;
    public TextField txtEmail;
    public static Student editedStudent;

    public void submit(ActionEvent actionEvent) {
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setTel(tel);
            StudentRepository sp = new StudentRepository();
            if(sp.update(editedStudent)){
                backToList();
            }else {
                System.out.println("Error");
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList() throws Exception {
        Parent list = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(list,800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book?");
            alert.setHeaderText("Are you sure delete students:"+editedStudent);
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get()==ButtonType.OK){
                StudentRepository sp = new StudentRepository();
                if(sp.delete(editedStudent)){
                    backToList();
                }else {
                    System.out.println("Error");
                }
            }
        }catch(Exception e){

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedStudent!=null){
            txtName.setText(editedStudent.getName());
            txtEmail.setText(editedStudent.getEmail());
            txtTel.setText(editedStudent.getTel());
        }

    }
}
