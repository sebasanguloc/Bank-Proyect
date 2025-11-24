package repositories.interfaces;

import models.dto.CustomerDto;
import models.dto.PersonDto;

import java.util.List;

public interface ICustomerRepository {

    List<CustomerDto> findAll();

    PersonDto findByEmail(String email);

    void save(CustomerDto customerDto);
}
