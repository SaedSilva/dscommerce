package br.dev.saed.dscommerce.services;

import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.entities.Product;
import br.dev.saed.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service // Indica que a classe é um componente de serviço
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // Indica que é uma transação de leitura
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        return new ProductDTO(product);
    }

}
