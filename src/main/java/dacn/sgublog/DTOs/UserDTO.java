package dacn.sgublog.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {
    private int page;
    private int totalPages;
    private int userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int role;
    private int isActive;

    public boolean hasPrevious(){
        return page>0;
    }

    public boolean hasNext(){
        return page < (totalPages - 1);
    }
}
