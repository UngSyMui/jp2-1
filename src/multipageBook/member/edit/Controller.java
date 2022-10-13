package JP2.multipageBook.member.edit;

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
    public TextField txtEmail;
    public Text errors;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setText(JP2.multipageBook.member.list.Controller.editMember.getName());
        txtCode.setText(String.valueOf(JP2.multipageBook.member.list.Controller.editMember.getCode()));
        txtEmail.setText(JP2.multipageBook.member.list.Controller.editMember.getEmail());
        txtCode.setEditable(false);
    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("List Member");
        Main.bookStage.setScene(listScene);
    }

    public void editMember(ActionEvent actionEvent) {
        try{
            errors.setVisible(false);
            if(txtName.getText().isEmpty()){
                throw new Exception("Vui lòng nhập tên member");
            }
            if(!txtEmail.getText().contains("@")||txtEmail.getText().startsWith("@")||txtEmail.getText().endsWith("@")){
                throw new Exception("Vui lòng nhập 1 email");
            }
            JP2.multipageBook.member.list.Controller.editMember.setName(txtName.getText());
            JP2.multipageBook.member.list.Controller.editMember.setEmail(txtEmail.getText());
            goToList(null);

        }catch (Exception e){
            errors.setVisible(true);
            errors.setText(e.getMessage());

        }
    }
}
