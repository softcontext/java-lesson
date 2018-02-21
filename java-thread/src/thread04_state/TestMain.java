package thread04_state;

public class TestMain {

	public static void main(String[] args) {
		ThreadStateObserver spt = new ThreadStateObserver(new TargetThread());
		spt.start();
	}

}
