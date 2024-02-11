package hu.webler.weblerspringthymeleafbootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private String position;
    private String office;
    private Date startDate;
    private double salary;
}
