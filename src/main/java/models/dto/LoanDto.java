package models.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private Integer customerId;
    private String email;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private Integer termInMonths;
    private BigDecimal amountOwed;
    private Integer salesPersonId;
    private Integer officeId;
    private LocalDate approvalDate;

}
