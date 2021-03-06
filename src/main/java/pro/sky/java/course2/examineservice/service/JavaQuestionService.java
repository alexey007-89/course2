package pro.sky.java.course2.examineservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.repository.JavaQuestionRepository;

import java.util.*;

@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        javaQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(javaQuestionRepository.getAll());
        return questionList.get(random.nextInt(questionList.size()));
    }
}
