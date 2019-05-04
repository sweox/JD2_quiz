package net.sw.quiz.dao;


import net.sw.quiz.entity.Participant;

public interface ParticipantDAO {

    void addParticipant(Participant participant);

    Participant getParticipant(int idParticipant);

}
