package cho.example.api.qnaboard.controller;


import java.util.Optional;

import cho.example.api.qnaboard.domain.QnA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping(value="/qna")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class QnAController {

}
