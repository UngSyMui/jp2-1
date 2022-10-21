package library.student.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.dao.impls.StudentRepository;
import library.entities.Book;
import library.entities.Student;
import library.helper.Connector;

import java.util.ArrayList;

public class StudentCreateController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public void submit(ActionEvent actionEvent) {
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            Student s = new Student(null,name,email,tel);
            StudentRepository sp = new StudentRepository();
            if(sp.create(s)){
                goToList(null);
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
