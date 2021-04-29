package cho.example.api.news.service;

import cho.example.api.news.domain.News;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    public Optional<News> findByNewsNo(String newsNo);
    public Document connectUrl(String url) throws IOException;
    public List<News> newsFindAll();
    public void crawlingHome() ;
    public void optionalInit(String newsNo);
    Long saveAll(String category) throws IOException;
}
