package JP2.multipageBook.member.form;

import JP2.multipageBook.Main;
import JP2.multipageBook.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    public TextField txtName;
    public TextField txtCode;
    public TextField txtEmail;
    public Text errors;
    public void addMember(ActionEvent actionEvent) {
        try{
            errors.setVisible(false);
            if(txtName.getText().isEmpty()||txtCode.getText().isEmpty()){
                throw new Exception("Vui lòng nhập đầy đủ tên và mã member");
            }
            if(!txtEmail.getText().contains("@")||txtEmail.getText().startsWith("@")||txtEmail.getText().endsWith("@")){
                throw new Exception("Vui lòng nhập một email");
            }
            Integer num = Integer.parseInt(txtCode.getText());
            Member m = new Member(txtName.getText(),num,txtEmail.getText());
            for(Member s: JP2.multipageBook.member.list.Controller.listMember){
                if(s.getCode()==num){
                    return;
                }
            }
            JP2.multipageBook.member.list.Controller.listMember.add(m);
            goToList(null);

        }catch (Exception e){
            errors.setVisible(true);
            errors.setText(e.getMessage());
        }
    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("List Member");
        Main.bookStage.setScene(listScene);
    }
}
