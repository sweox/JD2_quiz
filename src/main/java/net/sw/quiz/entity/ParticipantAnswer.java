package net.sw.quiz.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "participant_answer")
public class ParticipantAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant_answer")
    private int idParticipantAnswer;

    @ManyToOne
    @JoinColumn(name = "fid_participant")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "fid_quiz")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "fid_question")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "fid_answer")
    private Answer answer;

    @Column(name = "question_time_start")
    private Date questionTimeStart;

    @Column(name = "question_time_end")
    private Date getQuestionTimeEnd;

    public ParticipantAnswer() {
    }

    public int getIdParticipantAnswer() {
        return idParticipantAnswer;
    }

    public void setIdParticipantAnswer(int idParticipantAnswer) {
        this.idParticipantAnswer = idParticipantAnswer;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Date getQuestionTimeStart() {
        return questionTimeStart;
    }

    public void setQuestionTimeStart(Date questionTimeStart) {
        this.questionTimeStart = questionTimeStart;
    }

    public Date getGetQuestionTimeEnd() {
        return getQuestionTimeEnd;
    }

    public void setGetQuestionTimeEnd(Date getQuestionTimeEnd) {
        this.getQuestionTimeEnd = getQuestionTimeEnd;
    }

    @Override
    public String toString() {
        return "ParticipantAnswer{" +
                "idParticipantAnswer=" + idParticipantAnswer +
                ", participant=" + participant +
                ", quiz=" + quiz +
                ", question=" + question +
                ", answer=" + answer +
                ", questionTimeStart=" + questionTimeStart +
                ", getQuestionTimeEnd=" + getQuestionTimeEnd +
                '}';
    }
}
