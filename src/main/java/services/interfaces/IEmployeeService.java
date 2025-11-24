package services.interfaces;

import models.dto.SalePersonDto;

import java.util.List;

public interface IEmployeeService {

    List<SalePersonDto> findAllCreditSalesPeople();

}
