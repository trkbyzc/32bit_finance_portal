package com.otuzikibit.finance_portal.service.mapper.user;

import com.otuzikibit.finance_portal.model.dto.user.UserCreateDto;
import com.otuzikibit.finance_portal.model.dto.user.UserResponseDto;
import com.otuzikibit.finance_portal.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "name")
    UserResponseDto toDto(User user);

    User toEntity(UserCreateDto dto);
}