/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salespeople_specialties")
public class SalespeopleSpecialty {

    @EmbeddedId
    private SalespeopleSpecialtyId id;

    @ManyToOne
    @MapsId("salespersonId")
    @JoinColumn(name = "salesperson_id")
    private CreditSalesPeople salesperson;

    @ManyToOne
    @MapsId("specialtyId")
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}
