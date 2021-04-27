package cho.example.api.qnaboard.controller;


import java.util.Optional;

import cho.example.api.qnaboard.domain.QnA;
import cho.example.api.qnaboard.service.QnAServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping(value="/qna")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class QnAController {
   private final QnAServiceImpl service;
   
   

   @PostMapping("")
	public ResponseEntity<?> doCreate(@RequestBody QnA qna){
		System.out.println("doCreate()"+qna.toString());
		service.save(qna);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
   
   @GetMapping("/list")
	public ResponseEntity<?> findAll(){
		System.out.println("getQnAFindAll()");

		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
   
   @GetMapping("/read/{id}")
   public ResponseEntity<Optional<QnA>> findById(@PathVariable long id){
	   System.out.println("findQnAOne()");
	   System.out.println("======= �Խñ� ������ =======");
	   
	   return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
   }
   
   @PutMapping("/modify/{boardNo}")
   public ResponseEntity<QnA> modify(@PathVariable("boardNo") long boardNo,@RequestBody QnA qna){
	   System.out.println("Modify()");
	   return new ResponseEntity<QnA>(service.save(qna),HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<QnA> doDelete(@PathVariable long id){
	   System.out.println("doDELETE()");
	   service.deleteById(id);
	   return new ResponseEntity<QnA>(HttpStatus.OK);
   }
}
