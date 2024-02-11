package hu.webler.weblerspringthymeleafbootstrap.view.model;

import hu.webler.weblerspringthymeleafbootstrap.view.value.PageItemType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean isActive;
}
