package dacn.sgublog.entities;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int article_id;
    private String title;
    @Lob
    private String content;
    private int author_id;
    private Date create_date;
    private Date update_date;
    private int category_id;
    private int status;
    private int view_count;
}
