package library.student.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.dao.impls.StudentRepository;
import library.entities.Student;
import library.enums.RepoType;
import library.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student, Integer> tdId;
    public TableColumn<Student, String> tdName;
    public TableColumn<Student, String> tdEmail;
    public TableColumn<Student, String> tdTel;
    public TableColumn<Student, Button> tdEdit;

    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent home = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(home,800,600));
    }

    public void goToCreate(ActionEvent actionEvent) throws Exception {
        Parent createStudent = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(new Scene(createStudent,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Student,Button>("edit"));
        ObservableList<Student> listStudent = FXCollections.observableArrayList();
        StudentRepository sp = (StudentRepository) RepositoryFactory.createRepository(RepoType.STUDENT);
        listStudent.addAll(sp.all());
        tbStudent.setItems(listStudent);

    }
}
