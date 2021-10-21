package com.ngoc.tour.repository;



import java.util.Date;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngoc.tour.entity.Evaluate;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Evaluate e SET e.content=:content, e.wdate=:date, e.rate=:rate  WHERE e.user.id=:userId and e.tour.id=:tourId")
	void updateEvaluate(int userId, int tourId, String content, Date date, @Param("rate") float rate);
	
	@Query("SELECT e FROM Evaluate e WHERE user.id=:userId and tour.id=:tourId")
	Evaluate findByUser(int userId, int tourId);
	
	
}
