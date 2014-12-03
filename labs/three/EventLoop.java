package labs.three;

import java.util.LinkedList;
import java.util.Queue;


public class EventLoop {
	private Queue<State> toDo = new LinkedList<State>();
	private Queue<State> complete = new LinkedList<State>();

	private RAMAuctionService rr = new RAMAuctionService("Src.txt");

	public void begin() {
		while (rr.hasNext()) {
			Auction a = rr.next();
			AuctionService.auctionmodel.put(a.getId(), a);
		}
		while (true) {
			State currentstate = new DefaultState(rr);
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
