package repositories.interfaces;

import models.dto.LoanDto;

public interface ILoanRepository {

    void save(LoanDto loanDto);

}
