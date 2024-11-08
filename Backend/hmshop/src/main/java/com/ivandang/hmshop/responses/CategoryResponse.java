package com.ivandang.hmshop.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivandang.hmshop.model.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private List<String> errors;

    @JsonProperty("category")
    private Category category;
}

