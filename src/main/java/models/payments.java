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

public class payments extends loans {
    private Integer paymentId;
    private Integer loanId;
    private Integer payment_methodId;
    private Date payment_date;
    private BigDecimal amount_paid;
    private Integer quota_number; 
}
