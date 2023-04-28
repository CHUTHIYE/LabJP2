package Lab1_slot3;

public class MyThread extends Thread{
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread name: " + currentThread.getName());

        MyThread myThread = new MyThread();
        myThread.setName("myJavaThread");
        System.out.println("Renamed thread to: " + MyThread.class.getName());

        myThread.start();
    }

    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2){
            System.out.println(i);
            try {
                Thread.sleep(1500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
