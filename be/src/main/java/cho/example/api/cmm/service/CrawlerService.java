package cho.example.api.cmm.service;

import cho.example.api.cmm.domain.Crawler;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    public List<?> scrapBugs(Crawler crawler) throws IOException;
}
