package labs.three;

import java.io.IOException;

public class AuctionThreeDriver {

	public static void main(String[] args) throws IOException {
		EventLoop bid = new EventLoop();
		bid.begin();
	}
}


// public static void main(String[] args) {
// // TODO Auto-generated method stub
// // EventLoop bid = new EventLoop();
// // bid.begin();
// // Auction tester = new Auction(001,"Magi",20);
// // System.out.println(tester.toString());
// RAMAuctionService test = new RAMAuctionService("src");
// test.delete((long) 20);
//
// }
