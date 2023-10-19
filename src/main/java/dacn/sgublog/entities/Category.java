package dacn.sgublog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Category {
    @Id
    private int categoryID;
    private String categoryName;
    private String description;
    private Date createDate;
    private Date updateDate;
}
