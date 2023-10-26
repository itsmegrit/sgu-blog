package dacn.sgublog.services;

import dacn.sgublog.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    public Optional<User> findUserById(int id);
}
