import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("Hello world!");
			}
		}, 0, 500);
	}
}
