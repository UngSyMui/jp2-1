package JP2.multipageBook;

import java.time.LocalDate;

public class BookMember {
    public LocalDate boDate;
    public LocalDate returnDate;
    public Book boBook;
    public Member boMember;

    public BookMember() {
    }

    public BookMember(LocalDate boDate, LocalDate returnDate, Book boBook, Member boMember) {
        this.boDate = boDate;
        this.returnDate = returnDate;
        this.boBook = boBook;
        this.boMember = boMember;
    }

    public LocalDate getBoDate() {
        return boDate;
    }

    public void setBoDate(LocalDate boDate) {
        this.boDate = boDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBoBook() {
        return boBook;
    }

    public void setBoBook(Book boBook) {
        this.boBook = boBook;
    }

    public Member getBoMember() {
        return boMember;
    }

    public void setBoMember(Member boMember) {
        this.boMember = boMember;
    }

    @Override
    public String toString() {
        return "BookMember{" +
                "boDate=" + boDate +
                ", returnDate=" + returnDate +
                ", boBook=" + boBook +
                ", boMember=" + boMember +
                '}';
    }
}
