package br.dev.saed.dscommerce.dto;

import br.dev.saed.dscommerce.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
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


}
