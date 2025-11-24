package repositories.implementations;

import models.dto.LoanDto;
import org.hibernate.Session;
import repositories.interfaces.ILoanRepository;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LoanRepositoryImpl implements ILoanRepository {

    @Override
    public void save(LoanDto loanDto) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String sql = """
                INSERT INTO loans (
                    customer_id,
                    office_id,
                    salesperson_id,
                    statement_id,
                    amount,
                    interest_rate,
                    term_in_months,
                    monthly_fee,
                    approval_date,
                    amount_owed
                ) VALUES (
                    ?,?,?,?,?,?,?,?,?,?
                )
                """;

        BigDecimal monthlyFee = calcularCuota(
                loanDto.getAmount(),
                loanDto.getInterestRate(),
                loanDto.getTermInMonths()
        );

        session.beginTransaction();
        session.createNativeQuery(sql)
                        .setParameter(1, loanDto.getCustomerId())
                        .setParameter(2, loanDto.getOfficeId())
                        .setParameter(3, loanDto.getSalesPersonId())
                        .setParameter(4, 1)
                        .setParameter(5, loanDto.getAmount())
                        .setParameter(6, loanDto.getInterestRate())
                        .setParameter(7, loanDto.getTermInMonths())
                        .setParameter(8, monthlyFee)
                        .setParameter(9, loanDto.getApprovalDate())
                        .setParameter(10, loanDto.getAmountOwed())
        .executeUpdate();
        session.getTransaction().commit();
    }

    public BigDecimal calcularCuota(BigDecimal monto, BigDecimal interes, int meses) {

        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);

        // 1 + interes
        BigDecimal unoMasInteres = interes.add(BigDecimal.ONE, mc);

        // (1 + interes)^(-meses)
        BigDecimal potenciaNegativa =
                BigDecimal.ONE.divide(unoMasInteres.pow(meses, mc), mc);

        // 1 - (1 + interes)^(-meses)
        BigDecimal denominador =
                BigDecimal.ONE.subtract(potenciaNegativa, mc);

        // monto * interes
        BigDecimal numerador = monto.multiply(interes, mc);

        // División final
        BigDecimal cuota = numerador.divide(denominador, 10, RoundingMode.HALF_UP);

        return cuota;
    }
}
