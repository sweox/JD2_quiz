package net.sw.quiz.dao;

import net.sw.quiz.entity.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerDAOImpl implements AnswerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Answer getAnswer(int idAnswer) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Answer.class, idAnswer);
    }
}
