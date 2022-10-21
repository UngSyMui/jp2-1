package library.bookrents.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.entities.Student;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookRentCreateController implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cbStudent;
    public DatePicker dpExpired;

    public void submid(ActionEvent actionEvent) {
        Book selected = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpExpired.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);


    }
}
