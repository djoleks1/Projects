package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ArticleRepository;
import vp.spring.rcs.model.Article;

@Component
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public <S extends Article> S save(S entity) {
		return articleRepository.save(entity);
	}

	public Page<Article> findAll(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}

	public Article findOne(Long id) {
		return articleRepository.findOne(id);
	}

	public void delete(Long id) {
		articleRepository.delete(id);
	}
	
	
}
