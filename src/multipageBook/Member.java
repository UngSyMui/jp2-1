package JP2.multipageBook;

public class Member {
    public String name;
    public Integer code;
    public String email;

    public Member() {
    }

    public Member(String name, Integer code, String email) {
        this.name = name;
        this.code = code;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", email='" + email + '\'' +
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
