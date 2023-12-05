package dacn.sgublog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Image {
    @Id
    private int imageId;
    private String url;
    private int articleId;
    private Date uploadedDate;
}
