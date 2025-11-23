package models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SalespeopleSpecialtyId implements Serializable {

    @Column(name = "salesperson_id")
    private Integer salespersonId;

    @Column(name = "specialty_id")
    private Integer specialtyId;

    // equals & hashCode
}
