package cho.example.api.news.controller;

import cho.example.api.news.domain.News;
import cho.example.api.news.service.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawling(@PathVariable String category)throws IOException {
        service.saveAll(category);
        System.out.println("카테고리"+category);
        return ResponseEntity.ok(service.saveAll(category));
    }
    @GetMapping("/{category}")
    public ResponseEntity<Long> bugs(@PathVariable String category)throws IOException {
        service.saveAll(category);
        System.out.println("카테고리"+category);
        return ResponseEntity.ok(service.saveAll(category));
    }
}
