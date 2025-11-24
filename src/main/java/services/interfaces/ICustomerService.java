package services.interfaces;

import models.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> findAll();

    void save(String email);
}
