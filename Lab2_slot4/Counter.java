package Lab2_slot4;

public class Counter {
    int value;

    public /*synchronized*/ void count(){
        value = 0;
        while (value < 10){
            System.out.println("Count: " + (++value));
            pause(300);
        }

    }
    public /*synchronized*/ void countdown(){
        value = 10;
        while (value >= 0){
            System.out.println("Countdown: " + (value--));
            pause(200);
        }
    }
    private void pause(long time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){}
    }
}
