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

        // get Session
        HttpSession session = request.getSession();
        // set attributes to the session
        session.setAttribute("questions", questions);
        session.setAttribute("participant", participant);

        // first question set to the session
        int numberQuestion = 0;
        session.setAttribute("numberQuestion", numberQuestion);

        return "redirect:/nextQuestion";
    }

    @RequestMapping(value = "/nextQuestion", method = RequestMethod.GET)
    public String nextQuestion(HttpServletRequest request,
                               Model model) {

        // get Session
        HttpSession session = request.getSession();
        // get number of question from session
        int numberQuestion = (int) session.getAttribute("numberQuestion");
        // get List Question from session
        List<Question> questions = (List<Question>) session.getAttribute("questions");

        // check end of questions List
        if (numberQuestion < questions.size()) {
            // add attribute JSP for begin test
            model.addAttribute("numberQuestion", numberQuestion);
            model.addAttribute("question", questions.get(numberQuestion));
            model.addAttribute("viewNumberQuestion", ++numberQuestion);

            return "question";
        } else {
            return "redirect:/finish";
        }
    }

    @RequestMapping(value = "/processQuestion", method = RequestMethod.POST)
    public String processQuestion(@RequestParam(value = "idAnswer") int idAnswer,
                                  HttpServletRequest request) {

        // get session
        HttpSession session = request.getSession();
        // get List Question from session
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        // get Participant from session
        Participant participant = (Participant) session.getAttribute("participant");
        // get number of question from session
        int numberQuestion = (int) session.getAttribute("numberQuestion");

        // create and add all to saveParticipantAnswer
        ParticipantAnswer participantAnswer = new ParticipantAnswer();
        participantAnswer.setParticipant(participant);
        participantAnswer.setQuiz(participant.getQuiz());
        participantAnswer.setQuestion(questions.get(numberQuestion));
        participantAnswer.setAnswer(quizService.getAnswer(idAnswer));
        quizService.saveParticipantAnswer(participantAnswer);

        // increase number question
        session.setAttribute("numberQuestion", ++numberQuestion);

        return "redirect:/nextQuestion";
    }


    @RequestMapping(value = "finish")
    public String resultQuiz() {



        return "finish";
    }

}
