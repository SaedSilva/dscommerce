package br.dev.saed.dscommerce.controllers;

import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

// Anotações que ficam acima da declaração da classe
@RestController // Indica que a classe é um controlador REST
@RequestMapping(value = "/products") // Define o caminho base para as requisições
public class ProductController {

    @Autowired
    private ProductService service;

    // Anotações que ficam acima da declaração do método
    @GetMapping(value = "/{id}") // Indica que o método responde a requisições GET em /products/{id}
    public ProductDTO findById(@PathVariable Long id) { // @PathVariable indica que o parâmetro vem da URL
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping // Indica que o método responde a requisições POST
    public ProductDTO insert(@RequestBody ProductDTO dto) { // @RequestBody indica que o parâmetro vem no corpo da requisição
        return service.insert(dto);
    }

}
