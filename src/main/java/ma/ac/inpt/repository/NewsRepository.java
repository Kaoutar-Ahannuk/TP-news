package ma.ac.inpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.inpt.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

}
