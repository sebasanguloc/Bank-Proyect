import org.junit.jupiter.api.Test;
import repositories.implementations.EmployeeRepositoryImpl;
import repositories.interfaces.IEmployeeRepository;

public class EmployeeTest {

    @Test
    void findAllCreditSalesPeople(){
        IEmployeeRepository service = new EmployeeRepositoryImpl();
        service.findAllCreditSalesPeople().forEach(salePersonDto -> System.out.println(salePersonDto));
    }

}
