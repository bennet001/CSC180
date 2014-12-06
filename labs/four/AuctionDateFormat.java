package labs.four;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuctionDateFormat implements Converter<Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat();
	private SimpleDateFormat sdfparsing;
	private SimpleDateFormat sdfformatting;
	
	public AuctionDateFormat() {

	}

	public AuctionDateFormat(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public AuctionDateFormat(SimpleDateFormat forParsing,
			SimpleDateFormat forFormatting) {
		sdfparsing = forParsing;
		sdfformatting = forFormatting;
	}
	
	public Date parse(String fromString) {
		// TODO Auto-generated method stub
		Date getDate = null;
		try {
			getDate = getSdfparseing().parse(fromString);
		} catch (ParseException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
			//
		}
		return getDate;
	}

	@Override
	public String format(Date fromObject) {
		return getSdfformatting().format(fromObject);
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public SimpleDateFormat getSdfparseing() {
		if (sdfparsing != null){
			return sdfparsing;
		}
		return sdf;
	}

	public SimpleDateFormat getSdfformatting() {
		if(sdfformatting != null){
			return sdfformatting;
		}
		return sdf;
	}
}
