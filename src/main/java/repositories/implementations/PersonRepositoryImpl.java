package repositories.implementations;

import models.dto.PersonDto;
import org.hibernate.Session;
import repositories.interfaces.IPersonRepository;
import utils.HibernateUtil;

public class PersonRepositoryImpl implements IPersonRepository {

    @Override
    public void save(PersonDto personDto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            // Scrypt sql
            String sql = """
                    INSERT INTO persons (name, lastname, email) VALUES (?,?,?)
                    """;
            session.createNativeQuery(sql)
                            .setParameter(1,personDto.getName())
                            .setParameter(2,personDto.getLastname())
                            .setParameter(3,personDto.getEmail())
                    .executeUpdate();
        session.getTransaction().commit();
    }
}
