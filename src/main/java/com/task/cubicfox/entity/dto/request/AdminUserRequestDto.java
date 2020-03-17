package com.task.cubicfox.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.cubicfox.entity.Role;
import com.task.cubicfox.entity.Status;
import com.task.cubicfox.entity.User;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserRequestDto {
    private Long id;
    private Status status;
    private Date createDate;
    private String name;
    private String email;
    private String password;
    private List<Role> roles;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setStatus(status);
        user.setRoles(roles);
        user.setPassword(password);
        user.setCreateDate(createDate);
        return user;
    }

    public static AdminUserRequestDto fromUser(User user) {
        AdminUserRequestDto requestDto = new AdminUserRequestDto();
        requestDto.setId(user.getId());
        requestDto.setName(user.getName());
        requestDto.setEmail(user.getEmail());
        requestDto.setPassword(user.getPassword());
        requestDto.setRoles(user.getRoles());
        requestDto.setCreateDate(user.getCreateDate());
        requestDto.setStatus(user.getStatus());
        return requestDto;
    }
}
