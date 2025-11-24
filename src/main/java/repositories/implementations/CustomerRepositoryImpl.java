package repositories.implementations;

import models.dto.CustomerDto;
import models.dto.PersonDto;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import repositories.interfaces.ICustomerRepository;
import utils.HibernateUtil;

import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {

    @Override
    public List<CustomerDto> findAll() {
        // Copiar y pegar esta linea
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction(); // Inicaiar transaccion
        String sql = """
                SELECT
                        p.person_id AS personId,
                        p.name AS name,
                        p.lastname AS lastname,
                        p.email AS email
                FROM customers c
                JOIN persons p ON c.customer_id = p.person_id
                LIMIT 10
                """;
        List<CustomerDto> lista = session.createNativeQuery(sql)
                .addScalar("personId", StandardBasicTypes.INTEGER)
                .addScalar("name", StandardBasicTypes.STRING)
                .addScalar("lastname", StandardBasicTypes.STRING)
                .addScalar("email", StandardBasicTypes.STRING)
                .setResultTransformer(new org.hibernate.transform.AliasToBeanResultTransformer(CustomerDto.class))
                .list();

        session.getTransaction().commit(); // Cerrar transaccion
        return lista;
    }

    @Override
    public PersonDto findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = """
                SELECT
                        p.person_id AS personId,
                        p.name AS name,
                        p.lastname as lastname,
                        p.email AS email
                FROM persons p
                WHERE p.email = ?
                """;

        PersonDto personDto = (PersonDto) session.createNativeQuery(sql)
                .setParameter(1,email)
                .addScalar("personId", StandardBasicTypes.INTEGER)
                .addScalar("name", StandardBasicTypes.STRING)
                .addScalar("lastname", StandardBasicTypes.STRING)
                .addScalar("email", StandardBasicTypes.STRING)
                .setResultTransformer(new org.hibernate.transform.AliasToBeanResultTransformer(PersonDto.class))
                .uniqueResult();
        session.getTransaction().commit();

        return personDto;
    }

    @Override
    public void save(CustomerDto customerDto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // Scrypt sql
        String sql = """
                    INSERT INTO customers (customer_id) VALUES (?)
                    """;
        session.createNativeQuery(sql)
                .setParameter(1,customerDto.getPersonId())
                .executeUpdate();
        session.getTransaction().commit();
    }
}
