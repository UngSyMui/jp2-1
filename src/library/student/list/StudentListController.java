package library.student.list;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Student;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Observable;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student, Integer> tdId;
    public TableColumn<Student, String> tdName;
    public TableColumn<Student, String> tdEmail;
    public TableColumn<Student, String> tdTel;

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
        ObservableList<Student> listStudent = FXCollections.observableArrayList();
        try{
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("sid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id,name,email,tel);
                listStudent.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudent.setItems(listStudent);
        }

    }
}
