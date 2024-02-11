package hu.webler.weblerspringthymeleafbootstrap.view.model;

import hu.webler.weblerspringthymeleafbootstrap.view.value.PageItemType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paging {

    private static final int PAGINATION_STEP = 3; // TODO make it GENERIC!!!!

    private boolean isNextEnabled;
    private boolean isPreviousEnabled;
    private int pagesSize;
    private int pageNumber;

    private List<PageItem> items = new ArrayList<>();

    public static Paging of(int totalPage, int pageNumber, int pageSize) {
        Paging paging = new Paging();
        paging.setPagesSize(pageSize);
        paging.setPageNumber(pageNumber);
        paging.setPreviousEnabled(pageNumber > 1);
        paging.setNextEnabled(pageNumber < totalPage);

        if (totalPage < PAGINATION_STEP * 2 + 6) {
            paging.addPageItems(1, totalPage + 1, pageNumber);
        } else if (pageNumber < PAGINATION_STEP * 2 + 1) {
            paging.addPageItems(1, PAGINATION_STEP * 2 + 4, pageNumber);
            paging.last(totalPage);
        } else if (pageNumber > totalPage - PAGINATION_STEP * 2) {
            paging.first(pageNumber);
            paging.addPageItems(totalPage - PAGINATION_STEP * 2 - 2, totalPage + 1, pageNumber);
        } else {
            paging.first(pageNumber);
            paging.addPageItems(pageNumber - PAGINATION_STEP, pageNumber + PAGINATION_STEP + 1, pageNumber);
            paging.last(totalPage);
        }
        return paging;
    }

    public void addPageItems(int from, int to, int pageNumber) {
        for (int i = from; i < to; i++) {
            items.add(PageItem.builder()
                    .isActive(pageNumber != i)
                    .index(i)
                    .pageItemType(PageItemType.PAGE)
                    .build());
        }
    }

    public void last(int pagesSize) {
        items.add(PageItem.builder()
                .isActive(false)
                .pageItemType(PageItemType.DOTS)
                .build());

        items.add(PageItem.builder()
                .isActive(true)
                .index(pagesSize)
                .pageItemType(PageItemType.PAGE)
                .build());
    }

    public void first(int pageNumber) {
        items.add(PageItem.builder()
                .isActive(pageNumber != 1)
                .index(1)
                .pageItemType(PageItemType.PAGE)
                .build());

        items.add(PageItem.builder()
                .isActive(false)
                .pageItemType(PageItemType.DOTS)
                .build());
    }
}
