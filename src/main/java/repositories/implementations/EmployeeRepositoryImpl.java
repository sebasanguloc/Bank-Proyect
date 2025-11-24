package repositories.implementations;

import models.Employee;
import models.dto.SalePersonDto;
import org.hibernate.Session;
import repositories.interfaces.IEmployeeRepository;
import utils.HibernateUtil;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    @Override
    public void save(Employee employee) {

    }

    @Override
    public List<SalePersonDto> findAllCreditSalesPeople() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String sql = """
                SELECT
                    p.person_id AS personId,
                    p.name AS name,
                    p.lastname AS lastname,
                    o.name AS office,
                    o.office_id AS officeId
                FROM employees e
                JOIN persons p ON p.person_id = e.employee_id
                JOIN credit_salespeople csp ON e.employee_id = csp.salesperson_id
                JOIN offices o ON o.office_id = e.office_id
                LIMIT 10;
                """;

        List<SalePersonDto> lista = session.createNativeQuery(sql)
                .addScalar("personId", StandardBasicTypes.INTEGER)
                .addScalar("name", StandardBasicTypes.STRING)
                .addScalar("lastname", StandardBasicTypes.STRING)
                .addScalar("office", StandardBasicTypes.STRING)
                .addScalar("officeId", StandardBasicTypes.INTEGER)

                .setResultTransformer(new org.hibernate.transform.AliasToBeanResultTransformer(SalePersonDto.class))
                .list();

        session.close();
        return lista;

    }


}
