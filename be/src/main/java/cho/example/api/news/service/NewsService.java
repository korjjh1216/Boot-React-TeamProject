package cho.example.api.news.service;

import cho.example.api.cmm.domain.Crawler;
import cho.example.api.news.domain.News;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {
   // public Optional<News> findByNewsId(String newsId);
    public Document connectUrl(String url) throws IOException;
    public List<News> newsFindAll();
    public void crawlingHome() ;
   // public void optionalInit(String newsNo);
   List<News> saveAll(Crawler crawler) throws IOException;
   Page<News> retrieve(final Pageable pageable);

}
