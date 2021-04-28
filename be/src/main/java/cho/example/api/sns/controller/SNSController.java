package cho.example.api.sns.controller;

import cho.example.api.cmm.util.AbstractController;
import cho.example.api.sns.domain.SNS;
import cho.example.api.sns.service.SNSServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SNSController extends AbstractController<SNS> {
    private final SNSServiceImpl service;

    @PostMapping("")
    public ResponseEntity<Long> save(SNS sns) {
        return ResponseEntity.ok(service.save(sns));
    }

    @Override
    public ResponseEntity<Optional<SNS>> findById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SNS>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Long> count() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<SNS>> getOne(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Long> delete(SNS sns) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> existsById(long id) {
        return null;
    }
}
