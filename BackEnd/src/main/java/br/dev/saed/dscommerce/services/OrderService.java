package br.dev.saed.dscommerce.services;

import br.dev.saed.dscommerce.dto.OrderDTO;
import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.dto.ProductMinDTO;
import br.dev.saed.dscommerce.entities.Category;
import br.dev.saed.dscommerce.entities.Order;
import br.dev.saed.dscommerce.entities.Product;
import br.dev.saed.dscommerce.repositories.OrderRepository;
import br.dev.saed.dscommerce.repositories.ProductRepository;
import br.dev.saed.dscommerce.services.exceptions.DatabaseException;
import br.dev.saed.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service // Indica que a classe é um componente de serviço
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true) // Indica que é uma transação de leitura
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
