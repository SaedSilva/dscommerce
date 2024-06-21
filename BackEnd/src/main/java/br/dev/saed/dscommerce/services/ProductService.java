package br.dev.saed.dscommerce.services;

import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.entities.Product;
import br.dev.saed.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Indica que a classe é um componente de serviço
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // Indica que é uma transação de leitura
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true) // Indica que é uma transação de leitura
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(x -> new ProductDTO(x));
    }
}
