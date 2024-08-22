package br.dev.saed.dscommerce.controllers;

import br.dev.saed.dscommerce.dto.OrderDTO;
import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.dto.ProductMinDTO;
import br.dev.saed.dscommerce.services.OrderService;
import br.dev.saed.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Anotações que ficam acima da declaração da classe
@RestController // Indica que a classe é um controlador REST
@RequestMapping(value = "/orders") // Define o caminho base para as requisições
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
