package cho.example.api.cmm.service;

import cho.example.api.cmm.domain.Crawler;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class CrawlerServiceImpl implements CrawlerService{
    @Override
    public List<?> scrapBugs(Crawler crawler) throws IOException {
        Document document = connectUrl(crawler.getUrl());//"https://music.bugs.co.kr/char"
        Elements elements = document.select(crawler.getCssQuery());//"table.trackList>tbody>tr>th>p.title>a"

        for (int i = 0; i < elements.size(); i++) {
            Crawler.News news = new Crawler.News();
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
            news.setTitle(elements.get(i).text());

            System.out.println("****************news정보 :" +news.getClass() );
        }
        //return repo.count() > 0L? 1L : 0L;
        return null;
    }

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
}
