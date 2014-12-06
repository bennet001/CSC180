package labs.one;

import java.util.LinkedList;
import java.util.Queue;

import labs.one.two.InMemoryAuctionService;

public class EventLoop {
	private Queue<Event> toDo = new LinkedList<Event>();
	private Queue<Event> complete = new LinkedList<Event>();
	private Queue<Event> temp = new LinkedList<Event>();

	private InMemoryAuctionService auctionSiteList = new InMemoryAuctionService();

	public void begin() {
		while (true) {
			Event currentstate = new DefaultState(auctionSiteList);
			currentstate.show();
			Event s = currentstate.next();
			if (s != null) {
				toDo.add(s);
			}
			while(!toDo.isEmpty()){
				if ((!toDo.isEmpty())) {
					toDo.peek().show();
					complete.add(toDo.poll().next());
				}
			}
			swap();
		}
	}

	private  void swap() {
		// TODO Auto-generated method stub
		toDo = complete;
		complete = temp;
	}
}
