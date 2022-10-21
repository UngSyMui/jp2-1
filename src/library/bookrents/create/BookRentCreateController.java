package library.bookrents.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import library.dao.impls.BookRentRepository;
import library.dao.impls.BookRepository;
import library.dao.impls.StudentRepository;
import library.entities.Book;
import library.entities.BookRent;
import library.entities.Student;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookRentCreateController implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cbStudent;
    public DatePicker dpExpired;

    public void submid(ActionEvent actionEvent) {
        try{
            Book selecBook = cbBook.getSelectionModel().getSelectedItem();
            Student selecStudent = cbStudent.getSelectionModel().getSelectedItem();
            LocalDate dp = dpExpired.getValue();
            LocalDate de = dp.plusDays(20);
            BookRent br = new BookRent(null,selecBook.getId(),selecStudent.getId(),dp,de,"OK rent");
            BookRentRepository brp = new BookRentRepository();
            if(brp.create(br)){

            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        StudentRepository sp = new StudentRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ObservableList<Student> listStudent = FXCollections.observableArrayList();
        listStudent.addAll(sp.all());
        cbStudent.setItems(listStudent);
        ls.addAll(rp.all());
        cbBook.setItems(ls);


    }
}
