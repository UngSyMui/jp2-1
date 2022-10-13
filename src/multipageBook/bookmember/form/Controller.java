package multipageBook.bookmember.form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import multipageBook.Main;
import multipageBook.book.Book;
import multipageBook.bookmember.BookMember;
import multipageBook.member.Member;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller{
    public TextField txtNameMember;
    public TextField txtCodeMember;
    public TextField txtNameBook;
    public TextField txtCodeBook;
    public TextField txtBorrow;
    public TextField txtReturn;
    public Text eMember;
    public Text eBook;
    public Text eDate;
    public ListView<BookMember> lvBookMember;
    public static ObservableList<BookMember> listBookMember = FXCollections.observableArrayList();
    public void addBookMember(ActionEvent actionEvent) {
//        try{
//
//            eDate.setVisible(false);
//            Integer numMem = Integer.parseInt(txtCodeMember.getText());
//            for(Member m:multipageBook.member.list.Controller.listMember){
//                if(m.getCode()!=numMem||!m.getName().equals(txtNameMember.getText())){
//                    throw new Exception("Vui lòng nhập đúng thông tin member");
//                }
//            }
//            Member a =new Member();
//            for(Member m:multipageBook.member.list.Controller.listMember){
//                if(m.getCode()==numMem&&m.getName().equals(txtNameMember.getText())){
//                    a.setName(m.getName());
//                    a.setCode(m.getCode());
//                    a.setEmail(m.getEmail());
//                }
//            }
//
//            Integer numBook = Integer.parseInt(txtCodeBook.getText());
//            for (Book b:multipageBook.book.list.Controller.listBook){
//                if(b.getCode()!=numBook||!b.getName().equals(txtNameBook.getText())){
//                    throw new Exception("Vui lòng nhập đúng thông tin Book");
//                }
//            }
//            Book bb= new Book();
//            for (Book b:multipageBook.book.list.Controller.listBook){
//                if(b.getCode()==numBook&&b.getName().equals(txtNameBook.getText())){
//                    bb.setName(b.getName());
//                    bb.setCode(b.getCode());
//                    bb.setDescription(b.getDescription());
//                }
//            }
//
//            if(txtBorrow.getText().isEmpty()||txtReturn.getText().isEmpty()){
//                throw new Exception("Vui lòng nhập ngày mượn, ngày trả");
//            }
//            LocalDate bDate = LocalDate.parse(txtBorrow.getText());
//            LocalDate rDate =LocalDate.parse(txtReturn.getText());
//            BookMember bookMember = new BookMember(bDate,rDate,bb,a);
//            goToList(null);
//
//        }catch (Exception e){
//            eDate.setVisible(true);
//            eMember.setText(e.getMessage());
//            eDate.setText(e.getMessage());
//            eBook.setText(e.getMessage());
//
//        }
        try{
            eDate.setVisible(false);
            if(multipageBook.book.list.Controller.chooseBook==null||multipageBook.member.list.Controller.chooseMember==null){
                throw new Exception("Vui lòng chọn member,book");
            }
            if(txtBorrow.getText().isEmpty()||txtReturn.getText().isEmpty()){
                throw new Exception("Vui lòng nhập ngày mượn, ngày trả");
            }
            LocalDate bDate = LocalDate.parse(txtBorrow.getText());
            LocalDate rDate =LocalDate.parse(txtReturn.getText());
            BookMember bm = new BookMember(bDate,rDate,multipageBook.book.list.Controller.chooseBook,multipageBook.member.list.Controller.chooseMember);
            multipageBook.bookmember.list.Controller.listBookMember.add(bm);
            multipageBook.book.list.Controller.chooseBook=null;
            multipageBook.member.list.Controller.chooseMember=null;
            goToList(null);

        }catch (Exception e){
            eDate.setVisible(true);
            eDate.setText(e.getMessage());
        }

    }

    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }

    public void goToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("List BookMember");
        Main.bookStage.setScene(listScene);
    }

}
