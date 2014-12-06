package examples.weeksix;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CapitalizingInputStreams extends InputStream {
	private InputStream is;

	public CapitalizingInputStreams(InputStream is) {
		this.is = is;
	}

	@Override
	public int read() throws IOException {
		int ch = is.read();
		return Character.toUpperCase(ch);
	}

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.yahoo.com");
		URLConnection t = url.openConnection();
		InputStream i = t.getInputStream();
		InputStream capitalizer = new CapitalizingInputStreams(i);
		capitalizer.close();
	}
}
