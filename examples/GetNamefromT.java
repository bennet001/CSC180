package examples;

import labs.one.two.Auction;

public class GetNamefromT implements Transformer<Auction,String> {
	@Override
	public String Transform(Auction obj) {
		// TODO Auto-generated method stub
		return obj.get_Name();
	}
}
