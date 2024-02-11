package hu.webler.weblerspringthymeleafbootstrap.view.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Paged<T> {

    private List<T> contents;
    private int pageNumber;
    private int totalPage;

    public Paged(List<T> contents, int pageNumber, int totalPage) {
        this.contents = contents;
        this.pageNumber = pageNumber;
        this.totalPage = totalPage;
    }
}