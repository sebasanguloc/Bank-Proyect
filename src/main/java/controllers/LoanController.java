package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.dto.CustomerDto;
import models.dto.LoanDto;
import models.dto.SalePersonDto;
import repositories.implementations.CustomerRepositoryImpl;
import repositories.implementations.EmployeeRepositoryImpl;
import repositories.implementations.LoanRepositoryImpl;
import services.interfaces.ICustomerService;
import services.interfaces.IEmployeeService;
import services.interfaces.ILoanService;
import services.implementations.CustomerServiceImpl;
import services.implementations.EmployeeServiceImpl;
import services.implementations.LoanServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class LoanController {

    @FXML
    private ComboBox<CustomerDto> CBCustomer;

    @FXML
    private ComboBox<SalePersonDto> CBEmployee;

    @FXML
    private Button btnCreateLoan;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtAmountOwed;

    @FXML
    private TextField txtInterestRate;

    @FXML
    private TextField txtTotalFees;

    @FXML
    void createLoan(ActionEvent event) {
        CustomerDto customer = CBCustomer.getValue();
        BigDecimal amount = new BigDecimal(txtAmount.getText());
        BigDecimal interestRate = new BigDecimal(txtInterestRate.getText());
        int totalFees = Integer.parseInt(txtTotalFees.getText());
        BigDecimal amountOwed = new BigDecimal(txtAmountOwed.getText());
        SalePersonDto creditSalesPeople = CBEmployee.getValue();

        // Creando LoanDto
        LoanDto loanDto = new LoanDto(
                customer.getPersonId(),
                customer.getEmail(),
                amount,
                interestRate,
                totalFees,
                amountOwed,
                creditSalesPeople.getPersonId(),
                creditSalesPeople.getOfficeId(),
                LocalDate.now()
        );

        ILoanService loanService = new LoanServiceImpl(new LoanRepositoryImpl());

        loanService.save(loanDto);
    }

    @FXML
    void initialize() {
        IEmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
        List<SalePersonDto> salePersonDtoList = employeeService.findAllCreditSalesPeople();

        ObservableList<SalePersonDto> empleados = FXCollections.observableArrayList(salePersonDtoList);
        CBEmployee.setItems(empleados);

        ICustomerService customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
        List<CustomerDto> customerDtoList = customerService.findAll();

        ObservableList<CustomerDto> customers = FXCollections.observableArrayList(customerDtoList);
        CBCustomer.setItems(customers);
    }


}
