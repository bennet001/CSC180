package examples.weeknine;

import java.util.ArrayList;
import java.util.List;

public class DiningPhilosipher {
	private List<ChopStick> chopstick = new ArrayList<ChopStick>();
	private List<Philosopher> philosopher = new ArrayList<Philosopher>();
	private Table table;

	public DiningPhilosipher(int count) {
		this.table = new Table(count);
		for (int i = 0; i < count; i++) {
			int left = i;
			int right = (i+1)%count;
			if( i %2 ==0){
				philosopher.add(new Philosopher(i,table,left,right));
			}else{
				philosopher.add(new Philosopher(i,table,right,left));
			}
		}
//		for (int i = 0; i < count; i++) {
//			philosopher.add(new Philosopher(i, chopstick.get(i), chopstick
//					.get((i + 1) % count)));
//			
//		}
	}

	public void go() {
		List<Thread> threadtowaitfor = new ArrayList<Thread>();
		for (Philosopher philosophers : philosopher) {
			Thread t = new Thread(philosophers);
			if (philosophers.getWhich() % 2 == 0 && philosophers.getWhich() != philosopher.size()) {
				t.start();
			}
			threadtowaitfor.add(t);
		}
		for (Thread thread : threadtowaitfor) {
			try {
				if (threadtowaitfor.indexOf(thread) % 2 != 0) {
					thread.start();
					thread.join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DiningPhilosipher dp = new DiningPhilosipher(10);
		dp.go();
		for (Philosopher p : dp.philosopher) {
			System.out.printf("%s ate %d bites\n", p, p.getBites());
		}
	}
}
