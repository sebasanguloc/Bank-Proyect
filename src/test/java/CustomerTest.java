import org.junit.jupiter.api.Test;
import repositories.implementations.CustomerRepositoryImpl;
import repositories.interfaces.ICustomerRepository;

public class CustomerTest {

    @Test
    void findAll(){
        ICustomerRepository repository = new CustomerRepositoryImpl();
        repository.findAll().forEach(customerDto -> System.out.println(customerDto));
    }
}
