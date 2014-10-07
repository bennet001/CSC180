package lab.one;

import java.util.LinkedList;
import java.util.Queue;

import lab.one.two.InMemoryAuctionService;

public class EventLoop {
	Queue<Event> incomplete = new LinkedList<Event>();
	Queue<Event> Complete = new LinkedList<Event>();
	
	private InMemoryAuctionService auctionSiteList = new InMemoryAuctionService();

	public void begin() {
		Event currentstate = new DefaultState(auctionSiteList);
		incomplete.add(currentstate);
		boolean currentqueue = false;
		while (true) {
			if (!currentqueue) {
				incomplete.add(currentstate);
				if (incomplete.peek() != null) {
					incomplete.peek().show();
				}
				if (incomplete.peek().next() != null) {
					incomplete.add(incomplete.poll().next());
				}
				if (incomplete.peek().getClass() == SearchResultsState.class) {
					incomplete.peek().show();
					Complete.add(incomplete.poll());
				}
				if (incomplete.isEmpty()) {
					currentqueue = true;
				}
			}else {
				Complete.add(new DefaultState(auctionSiteList));
				if (Complete.peek() != null) {
					Complete.peek().show();
				}
				if (Complete.peek().next() != null) {
					Complete.add(Complete.poll().next());
				}
				if (Complete.peek().getClass() == SearchResultsState.class) {
					Complete.peek().show();
					incomplete.add(incomplete.poll());
				}
				if (Complete.isEmpty()) {
					currentqueue = false;
				}
			}
			// Event tempdefault = new DefaultState();
			// incomplete.add(tempdefault);
			// if(!incomplete.isEmpty()){
			// tempdefault.show();
			// tempdefault = tempdefault.next();
			// tempdefault = new DefaultState();
			// if(tempdefault.toString() != null){
			// incomplete.add(tempdefault);
			// }
			// }
			// tempdefault.show();
			// tempdefault = tempdefault.next();
			// tempdefault.show();
		}
	}
}
