package br.dev.saed.dscommerce.controllers;

import br.dev.saed.dscommerce.dto.ProductDTO;
import br.dev.saed.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Anotações que ficam acima da declaração da classe
@RestController // Indica que a classe é um controlador REST
@RequestMapping(value = "/products") // Define o caminho base para as requisições
public class ProductController {

    @Autowired
    private ProductService service;

    // Anotações que ficam acima da declaração do método
    @GetMapping(value = "/{id}") // Indica que o método responde a requisições GET em /products/{id}
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) { // @PathVariable indica que o parâmetro vem da URL
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(name, pageable));
    }

    @PostMapping // Indica que o método responde a requisições POST
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) { // @RequestBody indica que o parâmetro vem no corpo da requisição // @Valid indica que o objeto será validado
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri(); // Cria a URI do novo recurso
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}") // Indica que o método responde a requisições PUT em /products/{id}
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}") // Indica que o método responde a requisições GET em /products/{id}
    public ResponseEntity<Void> delete(@PathVariable Long id) { // @PathVariable indica que o parâmetro vem da URL
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
