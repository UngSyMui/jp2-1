package library.entities;

import library.dao.impls.BookRepository;
import library.dao.impls.StudentRepository;
import library.enums.RepoType;
import library.factory.RepositoryFactory;

import java.time.LocalDate;
import java.util.Date;

public class BookRent {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date rentDate;
    private Date expiredDate;
    private Integer status;
    private String bookName;
    private String studentName;
    private String statusLabel;

    public BookRent() {
    }

    public BookRent(Integer id, Integer bookId, Integer studentId, Date rentDate, Date expiredDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.expiredDate = expiredDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Book book(){
        return ((BookRepository)RepositoryFactory.createRepository(RepoType.BOOK)).findOne(this.getBookId());
//        BookRepository br = new BookRepository();
//        Book b = br.findOne(this.bookId);
//        return b;
    }
    public Student student(){
        return (Student) RepositoryFactory.createRepository(RepoType.STUDENT).findOne(this.getStudentId());
    }

    public String getBookName() {
        return this.book().getName();
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return this.student().getName();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStatusLabel() {
        return status ==0?"Chưa trả":"Đã trả";
    }

}
