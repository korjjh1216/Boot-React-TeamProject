package cho.example.api.sns.service;

import cho.example.api.cmm.service.AbstractService;
import cho.example.api.sns.domain.SNS;
import cho.example.api.sns.repository.SNSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class SNSServiceImpl extends AbstractService<SNS> implements SNSService {
    private final SNSRepository repo;
    @Override
    public Long save(SNS sns) {
        return (repo.save(sns) != null) ? 1L : 0L;
    }

    @Override
    public Optional<SNS> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<SNS> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional<SNS> getOne(long id) {
        return Optional.empty();
    }

    @Override
    public Long delete(SNS sns) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }
}
