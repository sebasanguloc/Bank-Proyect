package models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer{

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Person person;

    @Column(name = "birth_date")
    private Date birthDate;

    private String address;

    @Column(name = "credit_score")
    private Integer creditScore;

    @Column(name = "register_date")
    private Date registerDate;
    
}
