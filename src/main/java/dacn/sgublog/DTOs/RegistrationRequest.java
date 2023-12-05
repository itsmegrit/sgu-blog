package dacn.sgublog.DTOs;

import dacn.sgublog.entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private List<Role> roles;
}
