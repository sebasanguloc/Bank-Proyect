import models.*;
import org.junit.jupiter.api.Test;
import repositories.interfaces.ILoanRepository;
import repositories.implementations.LoanRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanTest {

    @Test
    void saveLoan(){
        Customer customer = new Customer();
        customer.setCustomerId(151);

        Office office = new Office();
        office.setOfficeId(1);

        Employee employee = new Employee();
        employee.setId(139);

        CreditSalesPeople creditSalesPeople = new CreditSalesPeople();
        creditSalesPeople.setEmployee(employee);

        Statement statement = new Statement();
        statement.setStatementId(3);

        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setOffice(office);
        loan.setSalesperson(creditSalesPeople);
        loan.setStatement(statement);
        loan.setAmount(BigDecimal.valueOf(7777));
        loan.setInterestRate(BigDecimal.valueOf(7.77));
        loan.setTermInMonths(10);
        loan.setMonthlyFee(BigDecimal.valueOf(7777));
        loan.setApprovalDate(LocalDate.now());
        loan.setAmountOwed(BigDecimal.valueOf(777));

        ILoanRepository loanRepository = new LoanRepositoryImpl();
        loanRepository.save(loan);
    }

}
