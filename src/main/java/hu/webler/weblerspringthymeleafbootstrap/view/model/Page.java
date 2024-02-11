package hu.webler.weblerspringthymeleafbootstrap.view.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Page<T> {

    List<T> contents;
    int totalPage;
}
