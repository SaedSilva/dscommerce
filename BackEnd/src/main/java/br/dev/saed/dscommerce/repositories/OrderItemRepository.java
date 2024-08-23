package br.dev.saed.dscommerce.repositories;

import br.dev.saed.dscommerce.entities.Order;
import br.dev.saed.dscommerce.entities.OrderItem;
import br.dev.saed.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
