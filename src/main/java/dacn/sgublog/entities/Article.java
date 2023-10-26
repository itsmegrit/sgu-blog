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
    @Column(name = "article_id")
    private int articleId;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "author_id")
    private int authorId;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "status")
    private int status;
    @Column(name = "view_count")
    private int viewCount;

}
