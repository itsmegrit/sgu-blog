package dacn.sgublog.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {
    private int page;
    private int totalPages;
    private int articleId;
    private String title;
    private String content;
    private String authorName; // Thêm thuộc tính để lưu tên tác giả
    private String categoryName; // Thêm thuộc tính để lưu tên danh mục
    private Date createDate;
    private int viewCount;

    public boolean hasPrevious(){
        return page>0;
    }

    public boolean hasNext(){
        return page < (totalPages - 1);
    }
}
