package pro.sky.java.course2.examineservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examineservice.domain.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    Set<Question> questions;

    public JavaQuestionRepository() {
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
        questions.add(new Question("Что такое цикл?", "Конструкция языка, " +
                "позволяющая выполнять один и тот же код многократно в зависимости от условий"));
        questions.add(new Question("Что такое Commit?",
                "Запись в истории изменений, которая содержит commit message (описание внесенных изменений)," +
                        " а также содержит обновленные файлы, подвергшиеся изменениям"));
        questions.add(new Question("Что такое строка?",
                "Неизменяемый массив символов"));
        questions.add(new Question("Что такое массив?",
                "Упорядоченная структура данных фиксированного размера"));
        questions.add(new Question("Что такое инкапсуляция?",
                "Это механизм языка, позволяющий ограничить прямой доступ к полям и методам класса извне " +
                        "(другим классам), с целью запретить бесконтрольную модификацию состояния объекта " +
                        "или вызов методов, которые также могут изменить его состояние"));
    }
}
