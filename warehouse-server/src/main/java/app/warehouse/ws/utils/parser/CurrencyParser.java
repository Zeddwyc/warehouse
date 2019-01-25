package app.warehouse.ws.utils.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class CurrencyParser {

	// https://minfin.com.ua/ua/currency/
	public void parseCurrencyByUrl(String websiteUrl) {
		try {
			Document doc = Jsoup.connect(websiteUrl).get();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
