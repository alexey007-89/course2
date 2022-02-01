package pro.sky.java.course2.examineservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.service.ExaminerService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return Set.copyOf(examinerService.getQuestion(amount));
    }
}
