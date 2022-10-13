package multipageBook.book.list;

import multipageBook.book.Book;
import multipageBook.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<Book> lvBook;
    public static ObservableList<Book> listBook = FXCollections.observableArrayList();
    public static Book editBook;
    public static Book chooseBook;

    public void addBook(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/form.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("AddBook");
        Main.bookStage.setScene(listScene);
    }

    boolean sortCode = true;
    public void sortCode(ActionEvent actionEvent) {
        Collections.sort(listBook, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortCode?o1.getCode()-o2.getCode():o2.getCode()-o1.getCode();
            }
        });
        sortCode =!sortCode;
    }

    public void removeBook(ActionEvent actionEvent) {
        editBook = lvBook.getSelectionModel().getSelectedItem();
        if(editBook==null) return;
        listBook.remove(editBook);
    }

    boolean sortName = true;
    public void sortName(ActionEvent actionEvent) {
        Collections.sort(listBook, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortName?o1.layTen().compareTo(o2.layTen()):o2.layTen().compareTo(o1.layTen());
            }
        });
        sortName =!sortName;
    }

    public void editBook(ActionEvent actionEvent) throws Exception {
        editBook = lvBook.getSelectionModel().getSelectedItem();
        if(editBook==null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("EditBook");
        Main.bookStage.setScene(listScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvBook.setItems(listBook);
        lvBook.refresh();
    }

    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }

    public void chooseBook(ActionEvent actionEvent) {
        chooseBook =lvBook.getSelectionModel().getSelectedItem();
        if(chooseBook==null) return;
    }
}
