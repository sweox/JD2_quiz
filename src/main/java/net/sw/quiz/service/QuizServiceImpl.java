package net.sw.quiz.service;

import net.sw.quiz.dao.ParticipantDAO;
import net.sw.quiz.dao.QuizDAO;
import net.sw.quiz.entity.Participant;
import net.sw.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDAO quizDAO;

    @Autowired
    private ParticipantDAO participantDAO;

    @Override
    @Transactional
    public List<Quiz> getAllQuiz() {

        return quizDAO.getAllQuiz();
    }

    @Override
    @Transactional
    public Quiz getQuiz(int idQuiz) {
        Quiz quiz = quizDAO.getQuiz(idQuiz);

        return quiz;
    }

    @Override
    @Transactional
    public void addParticipant(Participant participant) {
        participantDAO.addParticipant(participant);
    }


}
