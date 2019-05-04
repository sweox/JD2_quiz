package net.sw.quiz.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //todo GenerationType.IDENTITY
    @Column(name = "id_quiz")
    private int  idQuiz;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name = "difficulty")
    private int difficulty;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER )
    private List<Question> questions;

    public void addQuestion(Question question) {
        if(question == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
        question.setQuiz(this);
    }
    public void removeQuesion(Question question) {
        if(questions != null) {
            questions.remove(question);
            question.setQuiz(null);
        }
    }

    public Quiz() {
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return idQuiz == quiz.idQuiz &&
                difficulty == quiz.difficulty &&
                Objects.equals(title, quiz.title) &&
                Objects.equals(description, quiz.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuiz, title, description, difficulty);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "idQuiz=" + idQuiz +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                /*", question=" + question +*/  //todo cycle  stackOverflow!!!
                '}';
    }
}
