package net.sw.quiz.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private int idAnswer;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "fid_question")
    private Question question;

    public Answer() {
    }

    public Answer(String answer, boolean correct, Question question) {
        this.answer = answer;
        this.correct = correct;
        this.question = question;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        return idAnswer == that.idAnswer &&
                correct == that.correct &&
                Objects.equals(answer, that.answer) &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, answer, correct, question);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idAnswer=" + idAnswer +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
