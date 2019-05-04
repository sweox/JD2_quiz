package net.sw.quiz.dao;

import net.sw.quiz.entity.Participant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addParticipant(Participant participant) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(participant);
    }

    @Override
    public Participant getParticipant(int idParticipant) {
        return null;  //todo: null
    }
}
