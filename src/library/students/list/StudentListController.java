package library.students.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.entities.Book;
import library.entities.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,String> tdTel;
    public final static String connectionString ="jdbc:mysql://localhost:3306/t2203e";
    public final static String user="root";
    public final static String pwd=""; //mamp:"root"

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));
        ObservableList<Student> listStudent = FXCollections.observableArrayList();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student b = new Student(id,name,email,tel);
                listStudent.add(b);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudent.setItems(listStudent);
        }
    }
}
