import java.util.Queue;

public class Atc extends Thread {
    Queue<Call> calls;
    String name;
    int callsNumber;
    int circlesNumber;
    int wait;

    public Atc(String name, int wait, int callsNumber, int circlesNumber, Queue<Call> calls) {
        this.name = name;
        this.wait = wait;
        this.circlesNumber = circlesNumber;
        this.calls = calls;
        this.callsNumber = callsNumber;
    }

    public void run() {

        for (int i = 0; i < circlesNumber; i++) {
            for (int j = 0; j < callsNumber; j++) {
                calls.add(new Call());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
