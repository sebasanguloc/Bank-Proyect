package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.dto.PersonDto;
import repositories.implementations.CustomerRepositoryImpl;
import repositories.implementations.PersonRepositoryImpl;
import services.implementations.CustomerServiceImpl;
import services.implementations.PersonServiceImpl;
import services.interfaces.ICustomerService;
import services.interfaces.IPersonService;

public class CustomerController {

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtName;

    @FXML
    void crearCliente(ActionEvent event) {

        String name = txtName.getText();
        String lastname = txtLastname.getText();
        String email = txtEmail.getText();

        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setLastname(lastname);
        personDto.setEmail(email);

        // Creamos la persona
        IPersonService personService = new PersonServiceImpl(new PersonRepositoryImpl());
        personService.save(personDto);

        System.out.println("Se creo el person");

        // Creamos el customer
        ICustomerService customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
        customerService.save(email);
        System.out.println("Se creo el customer");
    }

}
