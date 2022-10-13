package multipageBook.bookmember.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import multipageBook.Main;
import multipageBook.bookmember.BookMember;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<BookMember> lvBookMember;
    public static ObservableList<BookMember> listBookMember = FXCollections.observableArrayList();
    public static BookMember editBookMember;

    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }

    public void removeBookMember(ActionEvent actionEvent) {
        editBookMember = lvBookMember.getSelectionModel().getSelectedItem();
        if(editBookMember==null) return;
        listBookMember.remove(editBookMember);
    }

    public void editBookMember(ActionEvent actionEvent) throws Exception {
        editBookMember = lvBookMember.getSelectionModel().getSelectedItem();
        if(editBookMember==null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Edit BookMember");
        Main.bookStage.setScene(listScene);
    }

    public void addBookMember(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/form.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Add BookMember");
        Main.bookStage.setScene(listScene);
    }

    boolean sortDate = true;
    public void sortDate(ActionEvent actionEvent) {
        Collections.sort(listBookMember, new Comparator<BookMember>() {
            @Override
            public int compare(BookMember o1, BookMember o2) {
                return sortDate?o1.getBoDate().compareTo(o2.getBoDate()):o2.getBoDate().compareTo(o1.getBoDate());
            }
        });
        sortDate=!sortDate;
    }

    boolean sortNameBook = true;
    public void sortNameBook(ActionEvent actionEvent) {
        Collections.sort(listBookMember, new Comparator<BookMember>() {
            @Override
            public int compare(BookMember o1, BookMember o2) {
                return sortNameBook?o1.boBook.getName().compareTo(o2.boBook.getName()):o2.boBook.getName().compareTo(o1.boBook.getName());
            }
        });
        sortNameBook=!sortNameBook;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvBookMember.setItems(listBookMember);
        lvBookMember.refresh();
    }
}
