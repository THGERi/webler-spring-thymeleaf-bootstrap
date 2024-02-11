package hu.webler.weblerspringthymeleafbootstrap.service;

import hu.webler.weblerspringthymeleafbootstrap.bootstrap.DataLoader;
import hu.webler.weblerspringthymeleafbootstrap.model.Employee;
import hu.webler.weblerspringthymeleafbootstrap.view.model.Paged;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final DataLoader dataLoader;

    /*@Override
    public List<Employee> getAllEmployees() {
        return dataLoader.getEmployees();
    }*/

    @Override
    public Paged<Employee> getAllEmployeesPaginated(int pageNumber) {
        return dataLoader.getEmployees(pageNumber);
    }
}
