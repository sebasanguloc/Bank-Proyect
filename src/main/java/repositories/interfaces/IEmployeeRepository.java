package repositories.interfaces;

import models.Employee;
import models.dto.SalePersonDto;

import java.util.List;

public interface IEmployeeRepository{

    /* CRUD */

    // CREATE
    void save(Employee employee);

    // READ
    List<SalePersonDto> findAllCreditSalesPeople();

    // UPDATE

    // DELETE
}
