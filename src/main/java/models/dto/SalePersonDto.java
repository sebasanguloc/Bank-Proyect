package models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalePersonDto {

    private Integer personId;
    private String name;
    private String lastname;
    private String office;
    private Integer officeId;

}
