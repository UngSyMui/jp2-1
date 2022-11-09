package demothread;

public class Main {
    public static void main(String[] args) {
        DemoNumber d = new DemoNumber();
        new Thread(()->{
            for(int i=0;i<20;i++){
                d.upValue();
                d.print();
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }).start();
        new Thread(()->{
            for(int i=0;i<20;i++){
                d.upValue();
                d.print();
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }).start();

        SubThread1 st1 = new SubThread1();

        SubRunnable r = new SubRunnable();
        Thread t = new Thread(r);
        st1.setDaemon(true);
        st1.start();
        t.start();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread t2 = new Thread(r2);
        t2.start();

        Runnable r3 =()->{

        };

        new Thread(()->{

        }).start();

        for(int i=0;i<20;i++){
            System.out.println("Main = "+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        System.out.println("Main Done");
    }
}
