package examples.oct1514;

import java.util.LinkedList;
import java.util.Queue;

import examples.oct1514.two.InMemoryAuctionService;


public class EventLoop {
	private Queue<Event> toDo = new LinkedList<Event>();
	private Queue<Event> complete = new LinkedList<Event>();
	private Queue<Event> temp = new LinkedList<Event>();

	private InMemoryAuctionService auctionSiteList = new InMemoryAuctionService();

	public void begin() {
		while (true) {
			Event currentstate = new DefaultState(auctionSiteList);
			currentstate.show();
			if (currentstate.next() != null) {
				toDo.add(currentstate);
			}
			while(!toDo.isEmpty()){
				if ((!toDo.isEmpty()) && temp.peek() != null) {
					toDo.peek().next().show();
					temp = swap();
					temp.add(toDo.poll().next());
					temp = swap();
				}
			}
			toDo = swap();
		}
	}

	private  Queue<Event> swap() {
		// TODO Auto-generated method stub
		if(temp.equals(toDo)){
			temp = complete;
		}
		else if(temp.equals(complete)){
			temp = toDo;
		}		
		return temp;
	}
}
