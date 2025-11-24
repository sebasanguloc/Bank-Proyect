package services.implementations;

import lombok.RequiredArgsConstructor;
import models.dto.LoanDto;
import repositories.interfaces.ILoanRepository;
import services.interfaces.ILoanService;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class LoanServiceImpl implements ILoanService {

    private final ILoanRepository loanRepository;

    @Override
    public void save(LoanDto loanDto) {
        loanRepository.save(loanDto);
    }

    @Override
    public boolean fieldsValidations(int amount, String email, BigDecimal interestRate, Integer termInMonths, BigDecimal monthlyFee, int amountOwed) {
        return false;
    }
}
