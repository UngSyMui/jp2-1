package library.dao.interfaces;

import library.entities.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> all();
    boolean create (Student st);
    boolean update(Student st);
    boolean delete(Student st);
    Student findOne(Integer id);
}
