/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_salespeople")
public class CreditSalesperson {

    @Id
    @Column(name = "salesperson_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "salesperson_id")
    private Employee employee;

    @Column(name = "sales_target")
    private Double salesTarget;

    @Column(name = "comission_rate")
    private Double commissionRate;

}
