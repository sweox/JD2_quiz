package net.sw.quiz.controller;

import net.sw.quiz.entity.Participant;
import net.sw.quiz.entity.ParticipantAnswer;
import net.sw.quiz.entity.Question;
import net.sw.quiz.entity.Quiz;
import net.sw.quiz.service.QuizService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/formParticipantQuiz")
    public String showAllQuiz(Model model) {

        // create new Participant
        Participant newParticipant = new Participant();

        // get all Quiz from service
        List<Quiz> quizList = quizService.getAllQuiz();

        // add attribute for JSP form
        model.addAttribute("quizList", quizList);
        model.addAttribute("newParticipant", newParticipant);

        return "form-participant-quiz";
    }

    @RequestMapping(value = "/processParticipantQuiz", method = RequestMethod.POST)
    public String processParticipantQuizBeginTest(@ModelAttribute("newParticipant") Participant participant,
                                                  @RequestParam("idQuiz") int idQuiz,
                                                  HttpServletRequest request,
                                                  Model model) {

        List<Quiz> allQuiz = quizService.getAllQuiz();

        // put to List Question id Quiz from form, add this Quiz to Participant
        List<Question> questions = null;
        for (Quiz quiz : allQuiz) {
            if (quiz.getIdQuiz() == idQuiz) {
                questions = quiz.getQuestions();
                participant.setQuiz(quiz);
                quizService.addParticipant(participant);
            }
        }

        // create participantAnswer object
        ParticipantAnswer participantAnswer = new ParticipantAnswer();

        // get Session
        HttpSession session = request.getSession();
        // set attributes to the session
        session.setAttribute("questions", questions);
        session.setAttribute("participant", participant);

        // first question set to the session
        int numberQuestion = 0;
        session.setAttribute("numberQuestion", numberQuestion);

        // add attribute JSP for begin test
        model.addAttribute("numberQuestion", numberQuestion);
        model.addAttribute("question", questions.get(numberQuestion));
        model.addAttribute("viewNumberQuestion", ++numberQuestion);
        model.addAttribute("participantAnswer", participantAnswer);

        return "question";
    }

//    @RequestMapping(value = "/beginQuiz", method = RequestMethod.GET)
//    public String beginQuiz(int idQuiz,
//                            Participant participant,
//                            Model model,
//                            HttpServletRequest request) {
//
//        List<Quiz> allQuiz = quizService.getAllQuiz();
//        List<Question> questions = null;
//        for (Quiz quiz : allQuiz) {
//            if (quiz.getIdQuiz() == idQuiz) {
//                questions = quiz.getQuestions();
//            }
//        }
//        int numberQuestion = 0;
//        model.addAttribute("numberQuestion", numberQuestion);
//        model.addAttribute("question", questions.get(numberQuestion));
//
////        return "question";
//        return nextQuestion(idQuiz, participant, 0, model);
//    }

    @RequestMapping("/nextQuestion")
    public String nextQuestion(@RequestParam("idAnswer") int idAnswer,
                               HttpServletRequest request,
                               Model model) {

        // get session
        HttpSession session = request.getSession();
        // get List Question from session
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        // get Participant from session
        Participant participant = (Participant) session.getAttribute("participant");
        // get number of question from session
        int numberQuestion = (int) session.getAttribute("numberQuestion");

        // process all Questions from List
        if (numberQuestion < questions.size() - 1) {

            // inc numberQuestion for next Question
            ++numberQuestion;

            // set Attribute number next Question into session
            session.setAttribute("numberQuestion", numberQuestion);

            // add attribute for JSP
            model.addAttribute("numberQuestion", numberQuestion);
            model.addAttribute("question", questions.get(numberQuestion));
            model.addAttribute("viewNumberQuestion", ++numberQuestion);
            model.addAttribute("quantityAnswer", questions.size());

            return "question";
        } else {

            return "finish";
        }
    }

}
