package models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person{

    private Integer customerId;
    private Date birth_date;
    private String address;
    private Integer credit_score;
    private Date register_date;
    
}
