package br.dev.saed.dscommerce.repositories;

import br.dev.saed.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
