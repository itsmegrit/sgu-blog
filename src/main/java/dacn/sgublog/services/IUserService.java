package dacn.sgublog.services;

import dacn.sgublog.DTOs.UserDTO;
import dacn.sgublog.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    public Optional<User> findUserById(int id);

    public Iterable<User> findAll();
    public Page<UserDTO> findAll(Pageable pageable);
}
