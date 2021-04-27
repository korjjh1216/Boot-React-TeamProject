package cho.example.api.qnaboard.service;

import java.util.List;
import java.util.Optional;

import cho.example.api.cmm.service.AbstractService;
import cho.example.api.qnaboard.domain.QnA;
import cho.example.api.qnaboard.repository.QnARepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAServiceImpl extends AbstractService<QnA> implements QnAService {
    private final QnARepository qnaRepo;


    @Override
    public void create(QnA qna) {
        // TODO Auto-generated method stub
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return qnaRepo.count();
    }

    @Override
    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<QnA> findAll() {
        // TODO Auto-generated method stub
        return qnaRepo.findAll();
    }

    @Override
    public Optional<QnA> findById(long id) {
        // TODO Auto-generated method stub
        return qnaRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        qnaRepo.deleteById(id);
        
    }

    @Override
    public QnA getOne(long id) {
        // TODO Auto-generated method stub
        return qnaRepo.getOne(id);
    }

    @Override
    public QnA save(QnA entity) {
        System.out.println(entity.toString());
        return qnaRepo.save(entity);
    }

	@Override
	public void delete(QnA entity) {
		// TODO Auto-generated method stub
		 qnaRepo.delete(entity);
	}


}
