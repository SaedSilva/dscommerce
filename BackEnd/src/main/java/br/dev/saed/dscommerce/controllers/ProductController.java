package br.dev.saed.dscommerce.controllers;

import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
