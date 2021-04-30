package cho.example.api.uss.controller;

import cho.example.api.news.domain.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cho.example.api.uss.domain.UserVo;
import cho.example.api.uss.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping(value="/user")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class UserController {
    private final UserServiceImpl service;

    @PostMapping("")
    public ResponseEntity<Long> join(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<List<News>> fetch(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
    @PutMapping("")
    public ResponseEntity<List<News>> update(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity<List<News>> delete(@RequestBody UserVo user){
        return ResponseEntity.ok(null);
    }
}
