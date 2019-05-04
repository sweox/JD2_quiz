package net.sw.quiz;

import net.sw.quiz.entity.Answer;
import net.sw.quiz.entity.Participant;
import net.sw.quiz.entity.Question;
import net.sw.quiz.entity.Quiz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Test {


    private final static String QUERY_FROM_QUIZ = "from Quiz";
    private final static String QUERY_FROM_QUESTIONS = "from Quiz";

    public static void main(String[] args) {

        selectFromQuiz3();
//        InsertToParticipant();

    }


    public static void selectFromQuiz() {
        SessionFactory sessionFactory =
                new Configuration().
                        configure("hibernate.cfg.xml").
                        addAnnotatedClass(Quiz.class)
                        .addAnnotatedClass(Question.class)
                        .addAnnotatedClass(Answer.class)
                        .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();


            List<Object[]> selectRaw = session.createQuery(QUERY_FROM_QUIZ).getResultList();

            System.out.println("=====Print selectRaw: " + selectRaw);

            for (Object raw : selectRaw) {
                Quiz title = (Quiz) raw;

                System.out.println("===Title: " + title.getDescription());
                System.out.println("===Title: " + title.getQuestions().size());
                System.out.println("==================");
            }

//            List resultList = session.createQuery(QUERY_FROM_QUIZ).getResultList();
//            for (Object r : resultList) {
//                if (r instanceof Quiz)
//                    System.out.println((((Quiz) r).getQuestions()));
//                else
//                    System.out.println("=== Not  quiz");
//            }


            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    public static void selectFromQuestions() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Quiz quiz = session.get(Quiz.class, 2);

            System.out.println(quiz);
            System.out.println("========================");
            System.out.println("========================");


            for (Question q : quiz.getQuestions()) {

                for (Answer qa : q.getAnswers()) {
                    if (qa.isCorrect()) {
                        System.out.println(q.getQuestion() + " " + qa.getAnswer());
                    }
                }
            }

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    public static void selectFromQuestions2() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            TypedQuery<Quiz> q = session.createQuery("SELECT q FROM Quiz q JOIN q.questions", Quiz.class);

            TypedQuery<Quiz> q2 = session.createQuery("SELECT q " +
                    "FROM Quiz q " +
                    "JOIN q.questions qs " +
                    "JOIN qs.answers", Quiz.class);

            TypedQuery<String> q3 = session.createQuery("SELECT q.title " +
                    "FROM Quiz q " +
                    "JOIN q.questions qs " +
                    "JOIN qs.answers qa", String.class);

            TypedQuery<String> q4 = session.createQuery("SELECT  qs.question " +
                    "FROM Quiz q " +
                    "JOIN q.questions qs " +
                    "JOIN qs.answers qa", String.class);


            TypedQuery<String> q5 = session.createQuery("SELECT  qa.answer " +
                    "FROM Quiz q " +
                    "JOIN q.questions qs " +
                    "JOIN qs.answers qa " +
                    "WHERE qa.correct = 1", String.class);


            Query query = session.createQuery("select q, qs.question " +
                    "from Quiz q " +
                    "JOIN q.questions qs ");

            List<Object[]> resultList = query.getResultList();

            System.out.println("ResultList size: " + resultList.size());

            for (Object[] o : resultList) {
                System.out.println("length arrayObject: " + o.length);
                System.out.println("o[0]: " + o[0] + "; o[1]: " + o[1]);
            }
            q.setFirstResult(0);
            q.setMaxResults(3);


//            List<Quiz> quiz = q.getResultList();
//            List<Quiz> quiz2 = q2.getResultList();

//            System.out.println(quiz);
//            System.out.println(quiz2);


            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    public static void selectFromParticipant() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();


            Query query = session.createQuery("select q, qs.question " +
                    "from Quiz q " +
                    "JOIN q.questions qs ");

            List<Object[]> resultList = query.getResultList();

            System.out.println("ResultList size: " + resultList.size());

            for (Object[] o : resultList) {
                System.out.println("length arrayObject: " + o.length);
                System.out.println("o[0]: " + o[0] + "; o[1]: " + o[1]);
            }


            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    public static void InsertToParticipant() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            List<Object[]> rawList = session.createQuery("select pt.name, q.title " +
                    "from Participant pt " +
                    "join pt.quiz q").getResultList();

            for (Object[] o : rawList) {
                System.out.println(o[0]);
                System.out.println(o[1]);
                System.out.println(((Quiz) o[1]).getDescription());
            }

            //session.persist();


            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    public static void selectFromQuiz2() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

//            Query query = session.createQuery("select q, qs.question " +
//                    "from Quiz q " +
//                    "JOIN q.question qs ");
//
//            List<Object[]> resultList = query.getResultList();
//
//            System.out.println("ResultList size: " + resultList.size());
//
//            for(Object[] o:resultList) {
//                System.out.println("length arrayObject: " + o.length);
//                System.out.println("o[0]: " + o[0] + "; o[1]: " + o[1]);
//            }

//            TypedQuery<Quiz> sel = session.createQuery("select q from Quiz q", Quiz.class);
//            TypedQuery<Quiz> sel = session
//                    .createQuery("select q from Quiz q join fetch q.question qs join fetch qs.answers", Quiz.class);
            TypedQuery<Quiz> sel = session
                    .createQuery("from Quiz q join fetch q.questions qs join fetch qs.answers", Quiz.class);

            List<Quiz> resultList = sel.getResultList();
            System.out.println(resultList);
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

            List<Question> questions = resultList.get(0).getQuestions();
            System.out.println(questions);
            for (Question q : questions) {
                for (Answer a : q.getAnswers()) {
                    System.out.println(a.getAnswer());
                }
                System.out.println("================");
            }

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public static void selectFromQuiz3() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

//            Query query = session.createQuery("select q, qs.question " +
//                    "from Quiz q " +
//                    "JOIN q.question qs ");
//
//            List<Object[]> resultList = query.getResultList();
//
//            System.out.println("ResultList size: " + resultList.size());
//
//            for(Object[] o:resultList) {
//                System.out.println("length arrayObject: " + o.length);
//                System.out.println("o[0]: " + o[0] + "; o[1]: " + o[1]);
//            }

//            TypedQuery<Quiz> sel = session.createQuery("select q from Quiz q", Quiz.class);
//            TypedQuery<Quiz> sel = session
//                    .createQuery("select q from Quiz q join fetch q.question qs join fetch qs.answers", Quiz.class);
            TypedQuery<Quiz> sel = session
                    .createQuery("from Quiz q", Quiz.class);

            List<Quiz> resultList = sel.getResultList();

            //System.out.println(resultList.get(0).getQuestions().get(0).getQuestion());

            tx.commit();

            //System.out.println("IUYJGJHFFJFJLFJFJKFJKFJKF " + resultList.get(0).getQuestions().get(0).getQuestion());


        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}

