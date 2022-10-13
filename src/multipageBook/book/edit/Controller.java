package multipageBook.book.edit;


import multipageBook.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtCode;
    public TextField txtDescription;
    public Text errors;

    public void editBook(ActionEvent actionEvent) {
        try{
            errors.setVisible(false);
            if(txtName.getText().isEmpty()||txtDescription.getText().isEmpty()){
                throw new Exception("Vui lòng nhập đầy đủ thông tin sách");
            }
            multipageBook.book.list.Controller.editBook.setName(txtName.getText());
            multipageBook.book.list.Controller.editBook.setDescription(txtDescription.getText());
            goToList(null);

        }catch (Exception e){
            errors.setVisible(true);
            errors.setText(e.getMessage());
        }

    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("ListBook");
        Main.bookStage.setScene(listScene);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setText(multipageBook.book.list.Controller.editBook.getName());
        txtCode.setText(String.valueOf(multipageBook.book.list.Controller.editBook.getCode()));
        txtDescription.setText(multipageBook.book.list.Controller.editBook.getDescription());
        txtCode.setEditable(false);
    }
    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }
}
