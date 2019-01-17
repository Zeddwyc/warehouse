package app.warehouse.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "brands", indexes = @Index(columnList = "brand_name"))
public class BrandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(name = "brand_name", nullable = false)
	private String name;

	@Column(name = "is_archived", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean isArchived;
}
