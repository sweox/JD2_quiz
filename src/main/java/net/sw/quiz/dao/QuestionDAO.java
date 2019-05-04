package net.sw.quiz.dao;

import net.sw.quiz.entity.Question;

import java.util.List;

public interface QuestionDAO {

    List<Question> getQuestions();
}
