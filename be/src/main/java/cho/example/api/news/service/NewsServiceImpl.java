package cho.example.api.news.service;

import cho.example.api.cmm.service.AbstractService;
import cho.example.api.news.domain.News;
import cho.example.api.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public Long saveAll(String category) throws IOException {
        //Document document = connectUrl("https://news.daum.net/" + category);
        Document document = connectUrl("https://music.bugs.co.kr/" + category);
        repo.deleteAll();
        //Elements elements = document.select("div.cont_aside>ol>li>strong>a");
        Elements elements = document.select("table.trackList>tbody>tr>th>p.title>a");
        Elements ranking = document.select("table.list>tbody>tr>td>div.ranking>strong");
        int count =0;
        for (int i = 0; i < elements.size(); i++) {
            News news = new News();
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());
            news.setNewsNo(ranking.get(i).text());


            count++;
            System.out.println("****************news정보 :" +news.toString() );
        }
        System.out.println("----크롤링카운트"+count);
       return 0L;
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
        return Optional.of(repo.getOne(id));
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

    @Override
    public Optional<News> findByNewsNo(String newsNo) {
        Optional.ofNullable(repo.findByNewsNo(newsNo)).ifPresent(System.out::println);
        return Optional.of(repo.findByNewsNo(newsNo));
    }

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



    @Override
    public void optionalInit(String newsNo) {
        Optional<String> optVal = Optional.empty();// Optional Initializer
    }
}
