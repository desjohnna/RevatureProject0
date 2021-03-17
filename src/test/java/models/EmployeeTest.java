package models;

import dev.gray.building_log_models.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    Employee employees1;
    Employee employees2;
    Employee employees3;

    @BeforeAll
    public void setUp() {
        company1 = new Company(8, "Ross");
        company2 = new Company(5, "Gap");
        company3 = new Company(6,"Intel");

        employees1 = new Employees(1, "Karen", "Smith", "Intel", "Manager", null , true, false);
        employees2 = new Employees(2, "DJ", "Gray", "Ross", "Manager",null , false, false);
        employees3 = new Employees(3, "Jeffery", "Barington", "Intel", "Team Member",null , false, false);
    }

    @Test
    @Transactional
    public void findByEmployeeByCompanyName() {
        //adding companies to test with
        companyRepo.save(company1);
        companyRepo.save(company2);
        companyRepo.save(company3);

        //adding employees to test with
        employeeRepo.save(employees1);
        employeeRepo.save(employees2);
        employeeRepo.save(employees3);

        //creating a list that = searching the employeeRepo findByCompanyName method for Intel.
        List<Employees> company3List = employeeRepo.findByCompanyName("Intel");

        //asserting that the list should return 2 employees
        assertEquals(2, company3List.size());

    }

    @After
    public void tearDown() {
        companyRepo.deleteAll();
        employeeRepo.deleteAll();
    }
}
