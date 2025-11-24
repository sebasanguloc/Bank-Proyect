package services.implementations;

import lombok.RequiredArgsConstructor;
import models.dto.PersonDto;
import repositories.interfaces.IPersonRepository;
import services.interfaces.IPersonService;

@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    // Traemos al respository
    private final IPersonRepository personRepository;

    @Override
    public void save(PersonDto personDto) {
        // Creamos persona
        personRepository.save(personDto);
    }
}
