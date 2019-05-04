package net.sw.quiz.service;

import net.sw.quiz.dao.AnswerDAO;
import net.sw.quiz.dao.ParticipantAnswerDAO;
import net.sw.quiz.dao.ParticipantDAO;
import net.sw.quiz.dao.QuizDAO;
import net.sw.quiz.entity.Answer;
import net.sw.quiz.entity.Participant;
import net.sw.quiz.entity.ParticipantAnswer;
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

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    ParticipantAnswerDAO participantAnswerDAO;

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

    @Override
    @Transactional
    public Answer getAnswer(int idAnswer) {
        return answerDAO.getAnswer(idAnswer);
    }

    @Override
    @Transactional
    public void saveParticipantAnswer(ParticipantAnswer participantAnswer) {
        participantAnswerDAO.saveParticipantAnswer(participantAnswer);
    }
}
