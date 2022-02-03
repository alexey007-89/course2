package pro.sky.java.course2.examineservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.service.JavaQuestionService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    public String add(@RequestParam("question") String questionText,
                      @RequestParam("answer") String questionAnswer) {
        javaQuestionService.add(questionText, questionAnswer);
        return message(questionText, questionAnswer, "добавлен");
    }

    @GetMapping("/java/remove")
    public String remove(@RequestParam("question") String questionText,
                      @RequestParam("answer") String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);
        javaQuestionService.remove(question);
        return message(questionText, questionAnswer, "удалён");
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return Set.copyOf(javaQuestionService.getAll());
    }

    private String message(String questionText, String questionAnswer, String action) {
        return "Вопрос " + questionText + " с ответом " + questionAnswer + " успешно " + action;
    }
}
