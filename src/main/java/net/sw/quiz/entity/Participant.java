package net.sw.quiz.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant")
    private int idParticipant;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fid_quiz")
    private Quiz quiz;

    @Column(name = "quiz_time_start")
    private Date quizTimeStart;

    @Column(name = "quiz_time_end")
    private Date quizTimeEnd;

    public Participant() {
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return idParticipant == that.idParticipant &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(quiz, that.quiz) /*&&
                Objects.equals(quiz_time_start, that.quiz_time_start) &&
                Objects.equals(quiz_time_end, that.quiz_time_end)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipant, name, email, quiz/*, quiz_time_start, quiz_time_end*/);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "idParticipant=" + idParticipant +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
