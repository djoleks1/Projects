package vp.spring.rcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Article;
import vp.spring.rcs.service.ArticleService;
import vp.spring.rcs.web.dto.CommonResponseDTO;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Page<Article>> findAll(Pageable pageable) {
		Page<Article> articles = articleService.findAll(pageable);
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Article> save(@RequestBody Article article) {
		Article newArticle = articleService.save(article);
		return new ResponseEntity<>(newArticle, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
		Article newArticle = articleService.findOne(id);
		newArticle.setTitle(article.getTitle());
		newArticle.setText(article.getText());
		newArticle.setCategory(article.getCategory());
		newArticle = articleService.save(newArticle);
		return new ResponseEntity<>(newArticle, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<CommonResponseDTO> update(@PathVariable Long id) {
		articleService.delete(id);
		return new ResponseEntity<>(new CommonResponseDTO("deleted"), HttpStatus.OK);
	}

}
