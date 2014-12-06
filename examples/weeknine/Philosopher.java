package examples.weeknine;

public class Philosopher implements Runnable {
	private int bites;
	private final int which;
	private final Table table;
	private final int ChopStickfirst;
	private final int ChopSticksecond;
	private boolean leftFirst;

//	public Philosopher(int which, ChopStick first, ChopStick second) {
//		this.which = which;
//		this.first = first;
//		this.second = second;
//	}
	public Philosopher(int which,boolean leftFirst, int firstChopStick, int secondChopStick, Table table) {
		this.which = which;
		this.leftFirst = leftFirst;
		this.table = table;
		this.ChopStickfirst = firstChopStick;
		this.ChopSticksecond = secondChopStick;
	}

	public Philosopher(int i, Table table2, int left, int right) {
		this.which = i;
		this.table = table2;
		this.ChopStickfirst = left;
		this.ChopSticksecond = right;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// for (int j = 0; j < 100; j++) {
		// System.out.printf("Eating bite %d for philospher #%d\n", j, which);
		// Thread.yield();
		// }
//		long time = System.currentTimeMillis();
//		while (System.currentTimeMillis() < time + 5 * 1000) {
//			synchronized (leftFirst?plate.getLeft():plate.getRight()) {
//				synchronized (leftFirst?plate.getRight():plate.getLeft()) {
//					bites++;
//				}
//			}
//		}

		ChopStick first = table.pickUpChopStick(this,ChopStickfirst);
		ChopStick second = table.pickUpChopStick(this,ChopSticksecond);
		
		if (table.takeBite(this,first,second)){
			bites++;
		}
		table.returnChopStick(this,ChopSticksecond);
		table.returnChopStick(this, ChopStickfirst);
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

//	public ChopStick getFirst() {
//		return first;
//	}
//
//	public ChopStick getSecond() {
//		return second;
//	}

	public String toString() {
		return "" + which;
	}

	public Table getTable() {
		return table;
	}

	public boolean isLeftFirst() {
		return leftFirst;
	}

}
