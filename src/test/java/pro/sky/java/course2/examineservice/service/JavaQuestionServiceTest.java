package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();
    Set<Question> expected = new HashSet<>();

    @BeforeEach
    public void SetUp() {
        expected.add(QUESTION_1);
        expected.add(QUESTION_2);
        expected.add(QUESTION_3);
        expected.add(QUESTION_4);
        expected.add(QUESTION_5);
    }

    @Test
    void shouldAddByQuestionAndAnswerWorkCorrect() {
        out.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        out.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        out.add(QUESTION_2.getQuestion(), QUESTION_2.getAnswer());
        out.add(QUESTION_3.getQuestion(), QUESTION_3.getAnswer());
        out.add(QUESTION_4.getQuestion(), QUESTION_4.getAnswer());
        out.add(QUESTION_5.getQuestion(), QUESTION_5.getAnswer());
        assertEquals(expected,out.getAll());
    }

    @Test
    void shouldAddWorkCorrect() {
        out.add(QUESTION_1);
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        out.add(QUESTION_5);
        assertEquals(expected,out.getAll());
    }

    @Test
    void shouldAddByQuestionAndAnswerReturnQuestionCorrect() {
        assertEquals(QUESTION_1,out.add(QUESTION_1.getQuestion(),QUESTION_1.getAnswer()));
    }

    @Test
    void shouldAddReturnQuestionCorrect() {
        assertEquals(QUESTION_1,out.add(QUESTION_1));
    }

    @Test
    void shouldRemoveWorkCorrect() {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        out.add(QUESTION_5);
        out.remove(QUESTION_5);
        out.remove(QUESTION_5);
        out.remove(QUESTION_4);
        expected.remove(QUESTION_5);
        expected.remove(QUESTION_4);
        assertEquals(expected,out.getAll());
    }

    @Test
    void shouldRemoveReturnQuestionCorrect() {
        assertEquals(QUESTION_1,out.remove(QUESTION_1));
    }

    @Test
    void shouldGetAllWorkCorrect() {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        out.add(QUESTION_5);
        assertEquals(expected,out.getAll());
    }
}