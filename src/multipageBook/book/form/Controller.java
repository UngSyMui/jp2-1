package multipageBook.book.form;

import multipageBook.book.Book;
import multipageBook.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    public TextField txtName;
    public TextField txtCode;
    public TextField txtDescription;
    public Text errors;


    public void addBook(ActionEvent actionEvent) {
        try{
            errors.setVisible(false);
            if(txtName.getText().isEmpty()||txtCode.getText().isEmpty()||txtDescription.getText().isEmpty()){
                throw new Exception("Vui lòng nhập đầy đủ thông tin sách");
            }
            Integer num = Integer.parseInt(txtCode.getText());
            Book b = new Book(txtName.getText(),num,txtDescription.getText());
            for(Book s: multipageBook.book.list.Controller.listBook){
                if(s.getCode()==num){
                    return;
                }
            }
            multipageBook.book.list.Controller.listBook.add(b);

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
    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }
}
