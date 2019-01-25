package app.warehouse.ws.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "currencies")
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "currency_code")
	private String currencyCode; // UAH, USD, EUR і тд
	
	@Column(name = "nbu", nullable = false, columnDefinition = "DECIMAL(6,4) DEFAULT 0")
	private BigDecimal nbu;
	
	@Column(name = "cash_purchase", nullable = false, columnDefinition = "DECIMAL(6,4) DEFAULT 0")
	private BigDecimal cashPurchase;
	
	@Column(name = "cash_sales", nullable = false, columnDefinition = "DECIMAL(6,4) DEFAULT 0")
	private BigDecimal cashSales;
	
	@Column(name = "black_purchase", nullable = false, columnDefinition = "DECIMAL(6,4) DEFAULT 0")
	private BigDecimal blackPurchase;
	
	@Column(name = "black_sales", nullable = false, columnDefinition = "DECIMAL(6,4) DEFAULT 0")
	private BigDecimal blackSales;
	
	@Column(name = "parsed_at")
	private LocalDateTime parsedAt = LocalDateTime.now();
	
}
