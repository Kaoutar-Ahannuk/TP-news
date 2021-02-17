package ma.ac.inpt.repository;

import ma.ac.inpt.model.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{
	
	

}
