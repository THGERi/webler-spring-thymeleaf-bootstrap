package hu.webler.weblerspringthymeleafbootstrap.service;

import hu.webler.weblerspringthymeleafbootstrap.model.Employee;
import hu.webler.weblerspringthymeleafbootstrap.view.model.Paged;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    // List<Employee> getAllEmployees();
    Paged<Employee> getAllEmployeesPaginated(int pageNumber);
}
