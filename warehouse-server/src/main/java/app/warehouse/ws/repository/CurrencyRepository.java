package app.warehouse.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.warehouse.ws.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

}
