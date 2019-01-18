package app.warehouse.ws.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "products", indexes = @Index(columnList = "product_code, product_name"))
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(name = "product_code", nullable = false, unique = true)
	private String productCode;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "quantity", columnDefinition = "INT DEFAULT 0")
	private int quantity;

	@Column(name = "cost_price", columnDefinition = "DECIMAL(9,2) DEFAULT 0")
	private double costPrice;

	@Column(name = "selling_price", columnDefinition = "DECIMAL(9,2) DEFAULT 0")
	private double sellingPrice;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private BrandEntity brand;

	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "is_archived", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean isArchived;
}
