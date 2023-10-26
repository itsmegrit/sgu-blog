package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IUserService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
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
}
