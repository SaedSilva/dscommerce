package br.dev.saed.dscommerce.services;

import br.dev.saed.dscommerce.dto.OrderDTO;
import br.dev.saed.dscommerce.entities.Order;
import br.dev.saed.dscommerce.entities.OrderItem;
import br.dev.saed.dscommerce.entities.Product;
import br.dev.saed.dscommerce.entities.enums.OrderStatus;
import br.dev.saed.dscommerce.repositories.OrderItemRepository;
import br.dev.saed.dscommerce.repositories.OrderRepository;
import br.dev.saed.dscommerce.repositories.ProductRepository;
import br.dev.saed.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service // Indica que a classe é um componente de serviço
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true) // Indica que é uma transação de leitura
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        order.setClient(userService.authenticated());

        dto.getItems().forEach(x -> {
            Product product = productRepository.getReferenceById(x.getProductId());
            OrderItem orderItem = new OrderItem(order, product, x.getQuantity(), product.getPrice());
            order.getItems().add(orderItem);
        });

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
