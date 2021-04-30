package cho.example.api.news.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @Column(length = 20, nullable = true)
    private String category;

    @Column(length = 512, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String address;

    @Builder
    public News(String category,
                String title, String address) {
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
