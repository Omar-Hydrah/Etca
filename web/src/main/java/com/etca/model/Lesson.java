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

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Lesson{

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@ManyToMany
	@JoinTable(
		name="lesson_word",
		joinColumns= {@JoinColumn(name="lesson_id")},
		inverseJoinColumns = {@JoinColumn(name="tag_id")}
	)
	private Set<Word> words = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name="lesson_grammar",
		joinColumns={@JoinColumn(name="lesson_id")},
		inverseJoinColumns = {@JoinColumn(name="grammar_id")}
	)
	private Set<Grammar> grammar = new HashSet<>();

	@ManyToOne
	@JoinColumn(name="language")
	private Language language;

	public Lesson(){

	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public Set<Word> getWords() { return this.words; }
	public void setWords(Set<Word> words) { this.words = words; }
	public Set<Grammar> getGrammar() { return this.grammar; }
	public void setGrammar(Set<Grammar> grammar) { this.grammar = grammar; }
	public Language getLanguage(){return this.language;}
	public void setLanguage(Language language){this.language = language;}
}