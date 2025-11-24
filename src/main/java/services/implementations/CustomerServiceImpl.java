package services.implementations;

import lombok.RequiredArgsConstructor;
import models.dto.CustomerDto;
import models.dto.PersonDto;
import repositories.interfaces.ICustomerRepository;
import services.interfaces.ICustomerService;

import java.util.List;

@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(String email) {
        // Buscar el Person que acabamos de crear
        PersonDto personDto = customerRepository.findByEmail(email);
        // Creamos customer
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPersonId(personDto.getPersonId());
        customerRepository.save(customerDto);
    }
}
