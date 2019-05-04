package net.sw.quiz.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private int idQuestion;

    @Column(name = "question")
    private String question;

    @Column(name = "question_difficulty")
    private int questionDifficulty;

    @ManyToOne
    @JoinColumn(name = "fid_quiz")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<Answer> answers;

    public void addQuestionAnswer(Answer answer) {
//        if(answers == null) {
//            answers = new ArrayList<>();
//        }
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeQuestionAnswer(Answer answer) {
        if(answers != null) {
            answers.remove(answer);
            answer.setQuestion(null);
        }
    }

    public Question() {
    }

    public Question(String question, int questionDifficulty, Quiz quiz) {
        this.question = question;
        this.questionDifficulty = questionDifficulty;
        this.quiz = quiz;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
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
        Question question1 = (Question) o;
        return idQuestion == question1.idQuestion &&
                questionDifficulty == question1.questionDifficulty &&
                Objects.equals(question, question1.question) &&
                Objects.equals(quiz, question1.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, question, questionDifficulty, quiz);
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", question='" + question + '\'' +
                ", questionDifficulty=" + questionDifficulty +
                ", quiz=" + quiz +
                '}';
    }
}
