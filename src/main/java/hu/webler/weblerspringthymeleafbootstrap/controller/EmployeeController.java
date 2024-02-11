package hu.webler.weblerspringthymeleafbootstrap.controller;

import hu.webler.weblerspringthymeleafbootstrap.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    /*@GetMapping
    public String renderEmployees(Model model) {
        model.addAttribute("employees", employeeServiceImpl.getAllEmployees());
        return "index";
    }*/

    @GetMapping()
    public String renderEmployeesPaginated(Model model, @RequestParam(defaultValue = "0") int pageNumber) {
        model.addAttribute("employees", employeeServiceImpl.getAllEmployeesPaginated(pageNumber));
        return "index";
    }
}
