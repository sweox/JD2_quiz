package net.sw.quiz.dao;

import net.sw.quiz.entity.ParticipantAnswer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantAnswerDAOImpl implements ParticipantAnswerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveParticipantAnswer(ParticipantAnswer participantAnswer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(participantAnswer);
    }
}
