package library.entities;

import java.time.LocalDate;

public class BookRent {
    public Integer id;
    public Integer bookId;
    public Integer studentId;
    public LocalDate rentDate;
    public LocalDate expiredDate;
    public String status;

    public BookRent() {
    }

    public BookRent(Integer id, Integer bookId, Integer studentId, LocalDate rentDate, LocalDate expiredDate, String status) {
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

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
