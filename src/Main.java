import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Call> calls = new ConcurrentLinkedQueue<Call>();
        final int ATCWAIT = 1000;
        final int CALLSNUMBER = 60;
        final int CIRCLESNUMBER = 1;
        final int OPERATORWAIT = 3000;
        final int OPERATORSNUMBER = 10;
        final Thread atc = new Thread(null, new Atc("АТС", ATCWAIT, CALLSNUMBER, CIRCLESNUMBER, calls));
        atc.start();
        for (int i = 1; i <= OPERATORSNUMBER; i++) {
            final Thread operator = new Thread(null, new Operator("Оператор" + i, OPERATORWAIT, calls));
            operator.start();
        }
    }
}
