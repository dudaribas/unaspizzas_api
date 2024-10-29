package com.unaspizzas_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unaspizzas_api.model.dto.LoginDTO;
import com.unaspizzas_api.model.dto.UserDTO;
import com.unaspizzas_api.model.entity.User;
import com.unaspizzas_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public User create(UserDTO userDTO) {
        return userRepository.save(userDTOToEntity(userDTO));
    }

    public User login(LoginDTO loginDTO) {
       return userRepository.findUserByEmail(loginDTO.getEmail());
    }

    private User userDTOToEntity(UserDTO userDTO) {
        return mapper.convertValue(userDTO, User.class);
    }

}


