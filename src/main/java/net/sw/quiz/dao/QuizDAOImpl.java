package net.sw.quiz.dao;

import net.sw.quiz.entity.Answer;
import net.sw.quiz.entity.Question;
import net.sw.quiz.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QuizDAOImpl implements QuizDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Quiz> getAllQuiz() {
        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery<Quiz> quizTypedQuery = currentSession
                .createQuery("from Quiz", Quiz.class);

        List<Quiz> quizzes = quizTypedQuery.getResultList();

        return quizzes;
    }

    @Override
    public Quiz getQuiz(int idQuiz) {
        Session currentSession = sessionFactory.getCurrentSession();

        Quiz quiz = currentSession.get(Quiz.class, idQuiz);

        return quiz;
    }


}
