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

    //TODO Implementação atríbuto pagamento.


}
