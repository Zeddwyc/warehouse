package app.warehouse.ws.utils.parser;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CurrencyParser {

	Connection.Response response = null;
	
	// https://minfin.com.ua/ua/currency/
	public void parse(String websiteUrl) throws IOException {
		System.out.println("This");
		try {
			Connection connection =  Jsoup.connect(websiteUrl);
			connection.userAgent("Mozilla");
			connection.timeout(5000);
			connection.referrer("http://google.com");
			
			response = connection.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test();
	}
	
	private void test() throws IOException {
		System.out.println("Status code: " + response.statusCode());
		
		Document doc = response.parse();
		
		Element table = doc.select("table").get(0);
		Elements tableRows = table.select("tr");
		
		for (Element el : tableRows) {
			Element row = el;
		    Elements cols = row.select("td");
		    
			cols.forEach(System.out::println);
		}
		
	}
	
}
