package com.task.cubicfox.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.cubicfox.entity.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {
    private Long id;
    private String name;
    private String email;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    public static UserRequestDto fromUser(User user) {
        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setId(user.getId());
        requestDto.setName(user.getName());
        requestDto.setEmail(user.getEmail());

        return requestDto;
    }
}
