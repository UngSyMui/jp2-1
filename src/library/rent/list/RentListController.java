package library.rent.list;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import library.Main;
import library.entities.Book;

import java.net.URL;
import java.util.ResourceBundle;

public class RentListController implements Initializable {
    public void goToForm(ActionEvent actionEvent) {
    }

    public void goToMain(ActionEvent actionEvent) throws Exception{
        Parent home = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(home,800,600));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
