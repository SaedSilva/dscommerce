package br.dev.saed.dscommerce.repositories;

import br.dev.saed.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {



}
