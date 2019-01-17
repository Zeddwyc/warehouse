package app.warehouse.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import app.warehouse.ws.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<Long> {

	boolean existsByProductCode(String productCode);

	Optional<ProductEntity> findByProductCode(String productCode);

	Optional<ProductEntity> findByProductNameIgnoreCase(String productName);

	List<ProductEntity> findByCategoryId(Long categoryId);

	List<ProductEntity> findByCategoryNameIgnoreCase(String categoryName);

	List<ProductEntity> findByBrandId(Long id);

	List<ProductEntity> findByBrandNameIgnoreCase(String brandName);
}
