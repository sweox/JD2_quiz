package net.sw.quiz.dao;

import net.sw.quiz.entity.Quiz;

import java.util.List;

public interface QuizDAO {

    List<Quiz> getAllQuiz();

    Quiz getQuiz(int idQuiz);
}
