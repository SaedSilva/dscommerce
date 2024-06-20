package br.dev.saed.dscommerce.entities;

import br.dev.saed.dscommerce.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Para garantir que o Instant seja armazenado no banco de dados sem o fuso horário
    private Instant moment;
    private OrderStatus status;
    // Lado do muitos para um
    @ManyToOne // Muitos pedidos para um cliente
    @JoinColumn(name = "client_id") // Nome da chave estrangeira
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // Um pedido para um pagamento, e se um pedido for apagado, o pagamento também será
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
