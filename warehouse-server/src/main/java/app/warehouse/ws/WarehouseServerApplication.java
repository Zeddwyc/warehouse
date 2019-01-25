package app.warehouse.ws;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import app.warehouse.ws.entity.CurrencyEntity;
import app.warehouse.ws.repository.CurrencyRepository;
import app.warehouse.ws.utils.parser.CurrencyParser;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "app.warehouse.ws.repository")
@EnableScheduling
public class WarehouseServerApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WarehouseServerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WarehouseServerApplication.class, args);
	}
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private CurrencyParser currencyParser;
	
	@Scheduled(cron = "0 */1 * * * *") // Run method every 1 minute
	public void backgroundTask() throws IOException {
		System.out.println("Job start at " + LocalDateTime.now());
		
		
		currencyParser.parse("https://minfin.com.ua/ua/currency/");
		
		// Test data - should be replaced by data, parsed from webpage
		CurrencyEntity currency = new CurrencyEntity();
		currency.setCurrencyCode("USD");
		currency.setNbu(new BigDecimal("27.7865"));
		currency.setCashPurchase(new BigDecimal("27.650"));
		currency.setCashSales(new BigDecimal("38.000"));
		currency.setBlackPurchase(new BigDecimal("27.770"));
		currency.setBlackSales(new BigDecimal("27.820"));
		
		currencyRepository.save(currency);
	}
}