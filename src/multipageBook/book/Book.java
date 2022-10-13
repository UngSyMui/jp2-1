package multipageBook.book;

public class Book {
    public String name;
    public Integer code;
    public String description;

    public Book() {
    }

    public Book(String name, Integer code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    public String layTen(){
        String ten = name.trim();
        if(ten.indexOf(" ")>0){
            int vt = ten.lastIndexOf(" ");
            return ten.substring(vt+1);
        }
        return ten;
    }
}
