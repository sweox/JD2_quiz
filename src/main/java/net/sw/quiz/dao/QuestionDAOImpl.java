package net.sw.quiz.dao;

import net.sw.quiz.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Question> getQuestions() {
        Session currentSession = sessionFactory.getCurrentSession();

//        currentSession.createQuery("select qs from Quiz q join Answer qs");

        return null;  //todo: null
    }
}
