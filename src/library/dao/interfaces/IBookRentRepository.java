package library.dao.interfaces;

import library.entities.BookRent;

import java.util.ArrayList;

public interface IBookRentRepository {
    ArrayList<BookRent> all();
    boolean create(BookRent bookrent);
    boolean update(BookRent bookrent);
    boolean delete(BookRent bookrent);
    BookRent findOne(Integer id);
}
