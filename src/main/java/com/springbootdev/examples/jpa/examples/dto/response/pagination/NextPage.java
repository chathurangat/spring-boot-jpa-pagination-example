package com.springbootdev.examples.jpa.examples.dto.response.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Data
public class NextPage {

    @JsonProperty("page_number")
    private Integer pageNumber;

    @JsonProperty("available")
    private boolean hasNext;

    public NextPage(Page page) {

        this.hasNext = page.hasNext();
        if (page.hasNext()) {
            Pageable nextPage = page.nextPageable();
            this.pageNumber = nextPage.getPageNumber();
        }
    }
}
