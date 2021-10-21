package com.ngoc.tour.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngoc.tour.entity.Evaluate;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.EvaluateRepository;

@Service
public class EvaluateService  implements DAO<Evaluate>{
	
	@Autowired
	private EvaluateRepository evaluateRepository;

	@Override
	public List<Evaluate> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluate findById(int id) {
		// TODO Auto-generated method stub
		return evaluateRepository.getById(id);
	}

	@Override
	public void insert(Evaluate vo) {
		// TODO Auto-generated method stub
		evaluateRepository.save(vo);
	}

	@Override
	public void update(Evaluate vo) {
		// TODO Auto-generated method stub
		evaluateRepository.updateEvaluate(vo.getUser().getId(), vo.getTour().getId(), vo.getContent(), vo.getWdate(),
				vo.getRate());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
