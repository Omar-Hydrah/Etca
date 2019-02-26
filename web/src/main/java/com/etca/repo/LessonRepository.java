package com.etca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.etca.model.Lesson;
import com.etca.model.Language;
import com.etca.model.Level;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
	
	Lesson findByTitle(String title);

	List<Lesson> findByLanguage(Language language);
	List<Lesson> findByLanguageAndLevel(Language language, Level level);
	List<Lesson> findAll();

	Lesson save(Lesson lesson);
}