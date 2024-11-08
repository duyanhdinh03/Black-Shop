package com.ivandang.hmshop.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivandang.hmshop.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("user")
    private User user;
}
