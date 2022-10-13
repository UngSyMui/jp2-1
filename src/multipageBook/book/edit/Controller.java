package JP2.multipageBook.book.edit;

import JP2.multipageBook.Book;
import JP2.multipageBook.Main;
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
            JP2.multipageBook.book.list.Controller.editBook.setName(txtName.getText());
            JP2.multipageBook.book.list.Controller.editBook.setDescription(txtDescription.getText());
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
        txtName.setText(JP2.multipageBook.book.list.Controller.editBook.getName());
        txtCode.setText(String.valueOf(JP2.multipageBook.book.list.Controller.editBook.getCode()));
        txtDescription.setText(JP2.multipageBook.book.list.Controller.editBook.getDescription());
        txtCode.setEditable(false);
    }
}
