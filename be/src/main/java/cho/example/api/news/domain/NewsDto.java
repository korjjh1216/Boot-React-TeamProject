package cho.example.api.news.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component @Data
public class NewsDto {
    private Long newsId;
    private String category;
    private String title;
    private String address;

/*    public static NewsDto of( News news){
        return NewsDto.builder()
                .newsId(news.getNewsId())
                .category(news.getCategory())
                .address(news.getAddress())
                .title(news.getTitle())
                .build();
    }*/
}
