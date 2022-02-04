package pro.sky.java.course2.examineservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.repository.MathQuestionRepository;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        mathQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(mathQuestionRepository.getAll());
        return questionList.get(random.nextInt(questionList.size()));
    }
}
