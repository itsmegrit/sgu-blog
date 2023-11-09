package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.DTOs.UserDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IUserService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        // Chuyển từ Entity Article sang DTO ArticleDTO
        Page<UserDTO> userDTOs = users.map(user -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setUsername(user.getUsername());
            dto.setFirstName(user.getFirstName());
            dto.setRole(user.getRole());
            dto.setPhone(user.getPhone());
            return dto;
        });
        return userDTOs;
    }
}
