import java.util.Random;

public class Events {
	public Events(){
		
	}
	
	public int randomEvents() {
		Random rng = new Random();
		int a = rng.nextInt(5) + 1;
		return a;
	}
	
	public int characterFate(int a) {
		Random rng = new Random();
		int b = rng.nextInt(10) + 1;
		if(b < a) {
			return -25;
		}
		else {
			return 0;
		}
	}
}
