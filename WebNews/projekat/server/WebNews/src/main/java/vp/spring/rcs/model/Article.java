package vp.spring.rcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Category category;
	
	private String title;
	
	@Column(length = 5000)
	private String text;


	public Article() {
		super();
	}


	public Article(Long id, Category category, String title, String text) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.text = text;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", category=" + category + ", title=" + title + ", text=" + text + "]";
	}
	
	
}
