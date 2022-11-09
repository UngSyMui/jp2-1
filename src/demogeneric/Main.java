package demogeneric;

public class Main {
    public static void main(String[] args) {
        Generic<String,Integer> g = new Generic<>();
        g.setDataX("Hello");
        Generic<Integer,String> g2 = new Generic<>();
        g2.setDataX(10);
        g.run("Xin chào");
        g.run(102);
    }
}
