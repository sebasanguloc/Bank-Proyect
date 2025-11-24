package repositories.interfaces;

import models.dto.PersonDto;

public interface IPersonRepository {

    void save(PersonDto personDto);

}
