package library.dao.impls;

import library.dao.interfaces.IBookRentRepository;
import library.entities.BookRent;
import library.helper.Connector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookRentRepository implements IBookRentRepository {
    @Override
    public ArrayList<BookRent> all() {
        ArrayList<BookRent> bookRents = new ArrayList<>();
        try{
            String sql_txt = "select * from bookrents";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                int bookId = rs.getInt("bookId");
                int studentId = rs.getInt("studentId");
                LocalDate rentDate = rs.getDate("rentDate").toLocalDate();
                LocalDate expiredDate = rs.getDate("expiredDate").toLocalDate();
                String status = rs.getString("status");
                BookRent br = new BookRent(id,bookId,studentId,rentDate,expiredDate,status);
                bookRents.add(br);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return bookRents;
    }

    @Override
    public boolean create(BookRent bookrent) {
        try{
            String sql_txt ="insert into bookrents(bookId,studentId,rentDate,expiredDate,status) values(?,?,?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(bookrent.getBookId());
            arr.add(bookrent.getStudentId());
            arr.add(bookrent.getRentDate());
            arr.add(bookrent.getExpiredDate());
            arr.add(bookrent.getStatus());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(BookRent bookrent) {
        try{
            String sql_txt ="update bookrents set bookId =?, studentId=?, rentDate =?, expiredDate =?,status=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(bookrent.getBookId());
            arr.add(bookrent.getStudentId());
            arr.add(bookrent.getRentDate());
            arr.add(bookrent.getExpiredDate());
            arr.add(bookrent.getStatus());
            arr.add(bookrent.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(BookRent bookrent) {
        try{
            String sql_txt ="delete from bookrents where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(bookrent.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return false;
    }

    @Override
    public BookRent findOne(Integer id) {
        try{
            String sql_txt ="select * from bookrents where id =?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id= rs.getInt("id");
                int bookId = rs.getInt("bookId");
                int studentId = rs.getInt("studentId");
                LocalDate rentDate = rs.getDate("rentDate").toLocalDate();
                LocalDate expiredDate = rs.getDate("expiredDate").toLocalDate();
                String status = rs.getString("status");
                return new BookRent(Id,bookId,studentId,rentDate,expiredDate,status);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
