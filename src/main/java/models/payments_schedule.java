/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class payments_schedule extends loans {
    private Integer scheduleId;
    private Integer loanId;
    private Integer installment_statusId;
    private BigDecimal installment_amount;
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal remaining_balance;
    private Integer installments_number;   
}
