package baithi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent add = FXMLLoader.load(getClass().getResource("create/create.fxml"));
        Main.bStage.setScene(new Scene(add,Main.width,Main.height));
    }

    public void listStudent(ActionEvent actionEvent) throws Exception {
        Parent list = FXMLLoader.load(getClass().getResource("list/list.fxml"));
        Main.bStage.setScene(new Scene(list,Main.width,Main.height));
    }
}
