  package exercises.five;

import exercises.five.two.Auction;

public class TableRowAuctionConverter implements Converter<Auction> {
	public TableRowAuctionConverter() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public Auction parse(String fromString) {
		// TODO Auto-generated method stub
		
		 
		return null;
	}

	@Override
	public String format(Auction fromObject) {
		// TODO Auto-generated method stub
		
		String[] list = fromObject.toString().split("\n");
		String sentence = String.format("%20s ", list[3]);
		return sentence;
	}
}
