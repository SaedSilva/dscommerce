package br.dev.saed.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Anotações que ficam acima da declaração da classe
@Entity // Indica que a classe é uma entidade do banco de dados
@Table(name = "tb_user") // Indica o nome da tabela no banco de dados
public class User {

    //Anotações que ficam acima da declaração dos atributos
    @Id // Indica que o atributo é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor do atributo é gerado automaticamente pelo banco de dados
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    //Lado do um para muitos
    @OneToMany(mappedBy = "client") // Um cliente para muitos pedidos
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                '}';
    }
}
