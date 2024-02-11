package hu.webler.weblerspringthymeleafbootstrap.bootstrap;

import hu.webler.weblerspringthymeleafbootstrap.model.Employee;
import hu.webler.weblerspringthymeleafbootstrap.view.model.Paged;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader {

    private final List<Employee> employees;

    public DataLoader() {
        this.employees = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            this.employees.add(new Employee("Employee " + (i + 1), "Position " + (i + 1),
                    "Office " + (i + 1), new Date(), 50000 + (i * 1000)));
        }
    }

    /*public List<Employee> getEmployees() {
        return this.employees;
    }*/

    public Paged<Employee> getEmployees(int page) {
        int startIndex = page * 10;
        int endIndex = Math.min(startIndex + 10, this.employees.size());
        List<Employee> pagedEmployees = this.employees.subList(startIndex, endIndex);
        int totalNumberOfPage = (int) Math.ceil((double) this.employees.size() / 10);
        return new Paged<>(pagedEmployees, page, totalNumberOfPage);
    }
}
