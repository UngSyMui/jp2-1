package library.dao.impls;

import library.dao.interfaces.IStudentRepository;
import library.entities.Student;
import library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try{
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("sid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id,name,email,tel);
                listStudent.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listStudent;
    }

    @Override
    public boolean create(Student st) {
        try{
            String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(st.getName());
            arr.add(st.getEmail());
            arr.add(st.getTel());
            if(conn.execute(sql_txt,arr)){
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Student st) {
        try{
            String sql_txt = "update students set name =?, email =?,tel =? where sid =?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(st.getName());
            arr.add(st.getEmail());
            arr.add(st.getTel());
            arr.add(st.getId());
            
            if(conn.execute(sql_txt,arr)){
                return true;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student st) {
        try{
            String sql_txt = "delete from students where sid =?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(st.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Student findOne(Integer id) {
        try{
            String sql_txt ="select * from students where id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("sid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                return new Student(Id,name,email,tel);
            }
        }catch (Exception e){

        }
        return null;
    }
}
