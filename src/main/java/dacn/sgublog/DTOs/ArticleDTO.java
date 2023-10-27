package dacn.sgublog.DTOs;

import dacn.sgublog.entities.Article;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO{
    private int page;
    private int totalPages;
    private int articleId;
    private int authorId;
    private String title;
    private String content;
    private String authorName; // Thêm thuộc tính để lưu tên tác giả
    private String categoryName; // Thêm thuộc tính để lưu tên danh mục
    private Date createDate;
    private Date updateDate;
    private int viewCount;
    private int status;

    public boolean hasPrevious(){
        return page>0;
    }

    public boolean hasNext(){
        return page < (totalPages - 1);
    }
}
