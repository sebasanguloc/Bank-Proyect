/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class loans extends Customer{
    
    private Integer loanId;
    private Integer customerId;
    private Integer officeId;
    private Integer salespersonId;
    private Integer statementId;
    private BigDecimal amount;
    private BigDecimal interest_rate;
    private Integer term_in_months;
    private BigDecimal monthly_fee;
    private Date approval_date;
    private BigDecimal amount_owed; 
    
}
