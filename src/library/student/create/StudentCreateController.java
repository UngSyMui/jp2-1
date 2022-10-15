package library.student.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
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
            String sql_txt ="insert into students(name,email,tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(email);
            arr.add(tel);
            if(conn.execute(sql_txt,arr)){
                goToList(null);
            }else {
                System.out.println("Errors");
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
