package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.DTOs.RegistrationRequest;
import dacn.sgublog.DTOs.UserDTO;
import dacn.sgublog.Exception.UsernameAlreadyExistsException;
import dacn.sgublog.entities.Role;
import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.RoleRepository;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest registrationRequest) throws UsernameAlreadyExistsException {
        if (userRepository.findByUsername(registrationRequest.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        } else {
            var user = new User(
                    registrationRequest.getUsername(),
                    passwordEncoder.encode(registrationRequest.getPassword()),
                    registrationRequest.getFirstName(),
                    registrationRequest.getLastName(),
                    registrationRequest.getEmail(),
                    Arrays.asList(roleRepository.findByName("ROLE_USER"))
            );
            userRepository.save(user);
            return user;
        }
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
            dto.setEmail(user.getEmail());
            dto.setFirstName(user.getFirstName());
            dto.setPhone(user.getPhone());
            return dto;
        });
        return userDTOs;
    }
}
