package com.springbootdev.examples.jpa.examples.dto.response.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PaginationDetails
{
    @JsonProperty("total_count")
    private Long totalCount;

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("page_number")
    private Integer pageNumber;

    @JsonProperty("next_page")
    private NextPage nextPage;

    @JsonProperty("previous_page")
    private PreviousPage previousPage;

    @JsonProperty("is_first_page")
    private Boolean isFirstPage;

    @JsonProperty("is_last_page")
    private Boolean isLastPage;

    public PaginationDetails(Page page) {
        this.totalCount = page.getTotalElements();
        this.pageCount = page.getNumberOfElements();
        this.pageNumber = page.getNumber();
        this.isFirstPage = page.isFirst();
        this.isLastPage = page.isLast();

        this.nextPage = new NextPage(page);
        this.previousPage = new PreviousPage(page);
    }
}
