package br.dev.saed.dscommerce.dto;

import br.dev.saed.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;
    @NotBlank(message = "Campo obrigatório") // Define que o campo não pode ser vazio
    @Size(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres") // Define o tamanho mínimo e máximo do campo
    private String name;
    @Size(min = 10, message = "O campo deve ter mais de 10 caracteres") // Define o tamanho mínimo e máximo do campo
    @NotBlank(message = "Campo obrigatório") // Define que o campo não pode ser vazio
    private String description;
    @Positive // Define que o valor deve ser positivo
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve ter pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        product.getCategories().forEach(x -> categories.add(new CategoryDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
