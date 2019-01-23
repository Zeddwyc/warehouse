package app.warehouse.ws.entity;

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
@Table(name = "categories", indexes = @Index(columnList = "category_name"))
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(name = "category_name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = true)
	private CategoryEntity parent;
	
	@Column(name = "is_archived", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean isArchived;
}
