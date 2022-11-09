package demothread;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainDemo {
    public static void main(String[] args) {

            Locale vi = new Locale("vi","VN");
            Locale.setDefault(vi);
            ResourceBundle rb1 = ResourceBundle.getBundle("demothread.message",vi);
            ResourceBundle rb2 = ResourceBundle.getBundle("demothread.message");
            System.out.println(rb1.getString("hello"));
            System.out.println(rb2.getString("hello"));


    }
}
