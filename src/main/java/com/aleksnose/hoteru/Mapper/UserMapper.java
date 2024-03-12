package com.aleksnose.hoteru.Mapper;

import com.aleksnose.hoteru.DTO.UserDTO;
import com.aleksnose.hoteru.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User entity);

    User userDTOToUser(UserDTO componentDto);
}
