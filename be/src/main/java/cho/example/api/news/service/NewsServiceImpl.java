package cho.example.api.news.service;

import cho.example.api.cmm.domain.Crawler;
import cho.example.api.cmm.service.AbstractService;
import cho.example.api.cmm.service.CrawlerServiceImpl;
import cho.example.api.news.domain.News;
import cho.example.api.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    private final NewsRepository repo;

    @Override
    public Long save(News news) {
        return (repo.save(news) != null) ? 1L : 0L;
    }

    @Override
    public List<News> saveAll(Crawler crawler) throws IOException {
        Document document = new CrawlerServiceImpl().connectUrl(crawler.getUrl()) ;//"https://news.daum.net/society"
        //Document document = connectUrl(crawler.getUrl());//"https://music.bugs.co.kr/char"
        repo.deleteAll();
       Elements elements = document.select("div.cont_aside>ol>li>strong>a");
       // Elements elements = document.select(crawler.getCssQuery());//"table.trackList>tbody>tr>th>p.title>a"
       // Elements ranking = document.select("table.list>tbody>tr>td>div.ranking>strong");
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            News news = new News();
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
            news.setTitle(elements.get(i).text());
            newsList.add(news);
            repo.save(news);
            //System.out.println("****************news정보 :" +news.getClass() );
        }
       return newsList;
    }

    @Override
    public Page<News> retrieve(Pageable pageable) {
        return repo.findAll(pageable);
    }


    @Override
    public Optional<News> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<News> findAll() {
        return repo.findAll();
    }

    @Override
    public Long count() {
        return repo.count();
    }

    @Override
    public Optional<News> getOne(long id) {
        //return Optional.of(repo.getOne(id));
        return Optional.empty();
    }


    @Override
    public Long delete(News news) {
        repo.delete(news);
        return (findById(news.getNewsId()).orElse(null) == null) ? 1L : 0L;
    }

    @Override
    public Boolean existsById(long id) {
        return repo.existsById(id);
    }


//--------------------------------------------크롤링 추가?

/*    @Override
    public Optional<News> findByNewsId(String newsId) {
        Optional.ofNullable(repo.findByNewsId(newsId)).ifPresent(System.out::println);
        return Optional.of(repo.findByNewsId(newsId));
    }*/


    @Override
    public Document connectUrl(String url) throws IOException {
        return Jsoup
                .connect(url)
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute()
                .parse();
    }

    @Override
    public List<News> newsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }



/*    @Override
    public void optionalInit(String newsNo) {
        Optional<String> optVal = Optional.empty();// Optional Initializer
    }*/
}
