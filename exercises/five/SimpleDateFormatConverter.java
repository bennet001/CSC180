package exercises.five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatConverter implements Converter<Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat();
	private SimpleDateFormat sdfparsing;
	private SimpleDateFormat sdfformatting;

	public SimpleDateFormatConverter() {

	}

	public SimpleDateFormatConverter(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public SimpleDateFormatConverter(SimpleDateFormat forParsing,
			SimpleDateFormat forFormatting) {
		sdfparsing = forParsing;
		sdfformatting = forFormatting;
	}

	@Override
	public Date parse(String fromString) {
		// TODO Auto-generated method stub
		getSdfparseing().applyLocalizedPattern(fromString);
		try {
			return getSdfparseing().parse(fromString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
