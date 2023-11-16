package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.DTOs.RegistrationRequest;
import dacn.sgublog.DTOs.UserDTO;
import dacn.sgublog.entities.Role;
import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest registrationRequest) {
        var user = new User(
                registrationRequest.getUsername(),
                registrationRequest.getPassword(),
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng"));
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        // Chuyển từ Entity Article sang DTO ArticleDTO
        Page<UserDTO> userDTOs = users.map(user -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setUsername(user.getUsername());
            dto.setFirstName(user.getFirstName());
            dto.setPhone(user.getPhone());
            return dto;
        });
        return userDTOs;
    }
}
