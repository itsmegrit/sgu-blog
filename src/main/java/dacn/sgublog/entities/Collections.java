package dacn.sgublog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Collections {
    @Id
    private int userId;
    private List<Integer> historyListID;
    private List<Integer> favoriteListID;
}
