package examples.weeknine.copy;

public class Philosopher implements Runnable {
	private int bites;
	private final int which;
	private final ChopStick first;
	private final ChopStick second;

	public Philosopher(int which, ChopStick first, ChopStick second) {
		this.which = which;
		this.first = first;
		this.second = second;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// for (int j = 0; j < 100; j++) {
		// System.out.printf("Eating bite %d for philospher #%d\n", j, which);
		// Thread.yield();
		// }
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() < time + 5 * 1000) {
			synchronized (first) {
				synchronized (second) {
					bites++;
				}
			}
		}

	}

	public int getWhich() {
		return which;
	}

	public int getBites() {
		return bites;
	}

	public void setBites(int bites) {
		this.bites = bites;
	}

	public ChopStick getFirst() {
		return first;
	}

	public ChopStick getSecond() {
		return second;
	}

	public String toString() {
		return "" + which;
	}

}
