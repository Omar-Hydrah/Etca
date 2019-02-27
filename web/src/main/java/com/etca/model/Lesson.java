package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(uniqueConstraints=
	@UniqueConstraint(columnNames={"title", "language_id"})
)
public class Lesson{

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String title;

	@Column
	private String content;

	@ManyToMany
	@JoinTable(
		name="lesson_word",
		joinColumns= {@JoinColumn(name="lesson_id")},
		inverseJoinColumns = {@JoinColumn(name="tag_id")}
	)
	private List<Word> words = new ArrayList<>();

	@ManyToMany
	@JoinTable(
		name="lesson_grammar",
		joinColumns={@JoinColumn(name="lesson_id")},
		inverseJoinColumns = {@JoinColumn(name="grammar_id")}
	)
	private List<Grammar> grammar = new ArrayList<>();

	@OneToMany(mappedBy="lesson", cascade=CascadeType.ALL)
	private List<Sentence> sentences;

	@ManyToOne
	@JoinColumn(name="language_id", nullable=false)
	private Language language;

	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;


	public Lesson(){

	}
	
	public Lesson(String title, String content, List<Sentence> sentences){
		this.title = title;
		this.content = content;
		this.sentences = sentences;
	}

	public Lesson(String title, List<Sentence> sentences){
		this.title = title;
		this.sentences = sentences;

	}

	public Lesson(String title, Language language, Level level, 
		String content, List<Sentence> sentences)
	{
		this.title = title;
		this.language = language;
		this.level = level;
		this.content = content;
		this.sentences = sentences;
	}

	public Lesson(String title, List<Word> words, List<Grammar> grammar, 
		List<Sentence> sentences)
	{
		this.title = title;
		this.words = words;
		this.grammar = grammar;
		this.sentences = sentences;
	}


	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public List<Word> getWords() { return this.words; }
	public void setWords(List<Word> words) { this.words = words; }
	public List<Grammar> getGrammar() { return this.grammar; }
	public void setGrammar(List<Grammar> grammar) { this.grammar = grammar; }
	public Language getLanguage(){return this.language;}
	public void setLanguage(Language language){this.language = language;}
	public List<Sentence> getSentences() { return this.sentences; }
	public void setSentences(List<Sentence> sentences) { this.sentences = sentences; }
	public Level getLevel() { return this.level; }
	public void setLevel(Level level) { this.level = level; }
	public String getContent() { return this.content; }
	public void setContent(String content) { this.content = content; }

	@Override
	public String toString(){
		return "{" + 
			"id: "       + this.id + ", " +
			"title: "    + this.title + ", " +
			"language: " + this.language + ", " +
			"level: "    + this.level    + ", " +
			"content: "  + this.content + ", " +

			"}";
	}
	
}