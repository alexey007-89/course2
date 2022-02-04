package pro.sky.java.course2.examineservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examineservice.domain.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    @PostConstruct
    public void init() {
        questions.add(new Question("2+2", "4"));
        questions.add(new Question("2*5", "10"));
        questions.add(new Question("100/4", "25"));
        questions.add(new Question("3*100", "300"));
        questions.add(new Question("1+2+3+4+5", "15"));
    }
}

