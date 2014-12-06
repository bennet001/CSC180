package labs.two;

import java.util.LinkedList;
import java.util.Queue;

import labs.two.two.InMemoryAuctionService;


public class EventLoop {
	private Queue<State> toDo = new LinkedList<State>();
	private Queue<State> complete = new LinkedList<State>();

	private InMemoryAuctionService auctionSiteList = new InMemoryAuctionService();

	public void begin() {
		while (true) {
			State currentstate = new DefaultState(auctionSiteList);
			currentstate.show();
			if (currentstate.next() != null) {
				toDo.add(currentstate.next());
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
		Queue<State> temp = new LinkedList<State>();
		toDo = complete;
		complete = temp;
	}
}
