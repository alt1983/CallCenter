import java.util.Queue;

public class Operator extends Thread {
    Queue<Call> calls;
    String name;
    int wait;


    public Operator(String name, int wait, Queue<Call> calls) {
        this.name = name;
        this.calls = calls;
        this.wait = wait;
    }

    public void run() {

        try {
            Thread.sleep(this.wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (calls.peek() != null) {
            calls.remove();
            try {
                Thread.sleep(this.wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
