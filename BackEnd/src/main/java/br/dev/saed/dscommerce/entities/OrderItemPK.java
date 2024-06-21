package br.dev.saed.dscommerce.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable // Indica que a classe é um subtipo de outra entidade
public class OrderItemPK {

    @ManyToOne // Mapeamento do relacionamento muitos-para-um
    @JoinColumn(name = "order_id") // Nome da chave estrangeira
    private Order order;

    @ManyToOne // Mapeamento do relacionamento muitos-para-um
    @JoinColumn(name = "product_id") // Nome da chave estrangeira
    private Product product;

    public OrderItemPK() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
