package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.AutoUserMapper;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        //Convert UserDTO into User JPA Entity
        //User newUser = UserMapper.mapUserDTOToUser(userDTO);

        //User newUser = modelMapper.map(userDTO, User.class);
        User newUser = AutoUserMapper.MAPPER.mapUserToUser(userDTO);

        User savedUser = userRepository.save(newUser);

        //Convert User JPA entity to UserDTO
        //UserDTO newUserDTO = UserMapper.mapUserToUserDTO(savedUser);
        //UserDTO newUserDTO = modelMapper.map(savedUser, UserDTO.class);
        UserDTO newUserDTO = AutoUserMapper.MAPPER.mapUserToUserDTO(savedUser);

        return newUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        //return UserMapper.mapUserToUserDTO(optionalUser.get());
        //return modelMapper.map(user, UserDTO.class);
        return AutoUserMapper.MAPPER.mapUserToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapUserToUserDTO)
        //      .collect(Collectors.toList());
        //return users.stream().map((user) -> modelMapper.map(user, UserDTO.class))
        //      .collect(Collectors.toList());

        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapUserToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        //return UserMapper.mapUserToUserDTO(updatedUser);
        //return modelMapper.map(updatedUser, UserDTO.class);
        return AutoUserMapper.MAPPER.mapUserToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
