package pro.sky.java.course2.examineservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();
    Set<Question> expected = new HashSet<>();

    @BeforeEach
    public void SetUp() {
        expected.add(JAVA_QUESTION_1);
        expected.add(JAVA_QUESTION_2);
        expected.add(JAVA_QUESTION_3);
        expected.add(JAVA_QUESTION_4);
        expected.add(JAVA_QUESTION_5);
    }

    @Test
    void shouldAddWorkCorrect() {
        out.add(JAVA_QUESTION_1);
        out.add(JAVA_QUESTION_1);
        out.add(JAVA_QUESTION_2);
        out.add(JAVA_QUESTION_3);
        out.add(JAVA_QUESTION_4);
        out.add(JAVA_QUESTION_5);
        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldAddReturnQuestionCorrect() {
        assertEquals(JAVA_QUESTION_1, out.add(JAVA_QUESTION_1));
    }

    @Test
    void shouldRemoveWorkCorrect() {
        out.add(JAVA_QUESTION_1);
        out.add(JAVA_QUESTION_2);
        out.add(JAVA_QUESTION_3);
        out.add(JAVA_QUESTION_4);
        out.add(JAVA_QUESTION_5);
        out.remove(JAVA_QUESTION_5);
        out.remove(JAVA_QUESTION_5);
        out.remove(JAVA_QUESTION_4);
        expected.remove(JAVA_QUESTION_5);
        expected.remove(JAVA_QUESTION_4);
        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldRemoveReturnQuestionCorrect() {
        assertEquals(JAVA_QUESTION_1, out.remove(JAVA_QUESTION_1));
    }

    @Test
    void shouldGetAllWorkCorrect() {
        out.add(JAVA_QUESTION_1);
        out.add(JAVA_QUESTION_2);
        out.add(JAVA_QUESTION_3);
        out.add(JAVA_QUESTION_4);
        out.add(JAVA_QUESTION_5);
        assertEquals(expected, out.getAll());
    }
}