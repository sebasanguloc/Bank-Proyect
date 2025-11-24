package services.interfaces;

import models.dto.LoanDto;

import java.math.BigDecimal;

public interface ILoanService {

    void save(LoanDto loanDto);

    boolean fieldsValidations(
            int amount,
            String email,
            BigDecimal interestRate,
            Integer termInMonths,
            BigDecimal monthlyFee,
            int amountOwed
    );

}
