package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
