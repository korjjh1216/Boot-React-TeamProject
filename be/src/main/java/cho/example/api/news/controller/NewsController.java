package cho.example.api.news.controller;

import cho.example.api.cmm.domain.Crawler;
import cho.example.api.news.domain.News;
import cho.example.api.news.service.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Log
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsServiceImpl service;

    @PostMapping("/news_scrap")
    public ResponseEntity<List<News>> crawling(@RequestBody Crawler crawler)throws IOException {
        service.saveAll(crawler);
        System.out.println("카테고리"+crawler.toString());
        return ResponseEntity.ok(service.saveAll(crawler));
    }
/*    @PostMapping("/bugs_scrap")
    public ResponseEntity<Long> bugs(@RequestBody Crawler crawler)throws IOException {
        service.saveAll(crawler);
        System.out.println("카테고리"+crawler.toString());
        return ResponseEntity.ok(service.saveAll(crawler));
    }*/

    @PostMapping("")
    public ResponseEntity<Long> post(@RequestBody News news){
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<Page<News>> retrieve(final Pageable pageable){
        return ResponseEntity.ok(service.retrieve(pageable));
    }
    @PutMapping("")
    public ResponseEntity<List<News>> update(@RequestBody News news){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity<List<News>> delete(@RequestBody News news){
        return ResponseEntity.ok(null);
    }
}
