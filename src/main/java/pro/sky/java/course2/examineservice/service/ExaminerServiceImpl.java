package pro.sky.java.course2.examineservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.NotValidAmountOfQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Qualifier("javaQuestionService")
    private final QuestionService javaQuestionService;

    @Qualifier("mathQuestionService")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        int amountOfAllQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount < 1 || amount > amountOfAllQuestions) {
            throw new NotValidAmountOfQuestionsException("The amount of questions is not valid");
        }
        Set<Question> questions = new HashSet<>();
        if (amount == amountOfAllQuestions) {
            questions.addAll(javaQuestionService.getAll());
            questions.addAll(mathQuestionService.getAll());
            return questions;
        }
        Random random = new Random();
        while (questions.size() < amount) {
            if (random.nextBoolean()) {
                questions.add(javaQuestionService.getRandomQuestion());
            } else {
                questions.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questions;
    }
}
