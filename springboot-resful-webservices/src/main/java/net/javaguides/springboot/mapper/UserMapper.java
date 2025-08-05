package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.entity.User;

public class UserMapper {




    public static UserDTO mapUserToUserDTO(User user) {

        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDTO;
    }

    public static User mapUserDTOToUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
