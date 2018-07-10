package com.springbootdev.examples.jpa.examples.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootdev.examples.jpa.examples.dto.response.pagination.PaginationDetails;
import com.springbootdev.examples.jpa.examples.model.User;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class UserResponse {

    private List<User> data;

    @JsonProperty("pagination_details")
    private PaginationDetails paginationDetails;

    public UserResponse(Page page) {
        this.data = page.getContent();
        paginationDetails = new PaginationDetails(page);
    }
}
