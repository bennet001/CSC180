  package labs.four;

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
		String sentence = String.format("%20s %20s %20 %20 %20 %20", list[4], list[0], list[3], list[2], list[1], list[5]);
		return sentence;
	}
}
