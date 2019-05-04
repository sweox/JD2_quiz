package net.sw.quiz.service;

import net.sw.quiz.entity.Participant;
import net.sw.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> getAllQuiz();

    Quiz getQuiz(int idQuiz);

    void addParticipant(Participant participant);
}
