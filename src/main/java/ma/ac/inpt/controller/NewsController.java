package ma.ac.inpt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.inpt.exception.ResourceNotFoundException;
import ma.ac.inpt.model.News;
import ma.ac.inpt.repository.NewsRepository;

//@CrossOrigin(origins = "*")
@ComponentScan({"ma.ac.inpt"})
@RestController
@RequestMapping("/api")
public class NewsController {
	@Autowired
    NewsRepository newsRepository;

    // Get All News
	@GetMapping("/news")
	public List<News> getAllNotes() {
	    return newsRepository.findAll();
	}

    // Create a new News
	@RequestMapping(value="/news",method=RequestMethod.POST)
	public News createNote(@Valid @RequestBody News news) {
	    return newsRepository.save(news);
	}

    // Get a Single News
	@GetMapping("/news/{id}")
	public News getNewsById(@PathVariable(value = "id") Long newsId) {
	    return newsRepository.findById(newsId)
	            .orElseThrow(() -> new ResourceNotFoundException("News", "id", newsId));
	}

    // Update a News
	@PutMapping("/news/{id}")
	public News updateNews(@PathVariable(value = "id") Long newsId,
	                                        @Valid @RequestBody News newsDetails) {

	    News news = newsRepository.findById(newsId)
	            .orElseThrow(() -> new ResourceNotFoundException("News", "id", newsId));

	    news.setTitre(newsDetails.getTitre());
	    news.setArticle(newsDetails.getArticle());

	    News updatedNews = newsRepository.save(news);
	    return updatedNews;
	}

    // Delete a News
	@DeleteMapping("/news/{id}")
	public ResponseEntity<?> deleteNews(@PathVariable(value = "id") Long newsId) {
	    News news = newsRepository.findById(newsId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", newsId));

	    newsRepository.delete(news);

	    return ResponseEntity.ok().build();
	}

}
