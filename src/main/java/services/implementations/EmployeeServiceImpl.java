package services.implementations;

import lombok.RequiredArgsConstructor;
import models.dto.SalePersonDto;
import repositories.interfaces.IEmployeeRepository;
import services.interfaces.IEmployeeService;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;

    @Override
    public List<SalePersonDto> findAllCreditSalesPeople() {
        return repository.findAllCreditSalesPeople();
    }
}
