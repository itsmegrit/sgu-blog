package dacn.sgublog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FeedBack {
    @Id
    private int feedBackId;
    private String title;
    private Date createDate;
    private String content;
    private int status;
}
