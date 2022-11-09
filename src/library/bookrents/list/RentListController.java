package library.bookrents.list;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.dao.impls.BookRentRepository;
import library.entities.BookRent;
import library.enums.RepoType;
import library.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RentListController implements Initializable {
    public TableColumn<BookRent,Integer> tdId;
    public TableView<BookRent> tbRents;
    public TableColumn<BookRent,String> tdBook;
    public TableColumn<BookRent,Integer> tdStudent;
    public TableColumn<BookRent, Date> tdRentDate;
    public TableColumn<BookRent,Date> tdExpiredDate;
    public TableColumn<BookRent,String> tdStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<BookRent,Integer>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<BookRent,String>("bookName"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<BookRent,Integer>("studentName"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<BookRent,Date>("rentDate"));
        tdExpiredDate.setCellValueFactory(new PropertyValueFactory<BookRent,Date>("expiredDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<BookRent,String>("statusLabel"));
        BookRentRepository br =(BookRentRepository) RepositoryFactory.createRepository(RepoType.BOOKRENT);
        tbRents.getItems().addAll(br.all());
    }
}
