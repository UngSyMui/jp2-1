package library.factory;

import library.dao.impls.BookRentRepository;
import library.dao.impls.BookRepository;
import library.dao.impls.StudentRepository;
import library.dao.interfaces.IRepository;
import library.enums.RepoType;

public class RepositoryFactory {

    private RepositoryFactory(){

    }
    public static IRepository createRepository(RepoType type){
        switch (type){
            case BOOK: return new BookRepository();
            case BOOKRENT: return new BookRentRepository();
            case STUDENT: return new StudentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số rồi");
        }
    }


}
