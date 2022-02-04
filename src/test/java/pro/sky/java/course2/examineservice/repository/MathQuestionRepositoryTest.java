package pro.sky.java.course2.examineservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

class MathQuestionRepositoryTest {
    private final MathQuestionRepository out = new MathQuestionRepository();
    Set<Question> expected = new HashSet<>();

    @BeforeEach
    public void SetUp() {
        expected.add(MATH_QUESTION_1);
        expected.add(MATH_QUESTION_2);
        expected.add(MATH_QUESTION_3);
        expected.add(MATH_QUESTION_4);
        expected.add(MATH_QUESTION_5);
    }

    @Test
    void shouldAddWorkCorrect() {
        out.add(MATH_QUESTION_1);
        out.add(MATH_QUESTION_1);
        out.add(MATH_QUESTION_2);
        out.add(MATH_QUESTION_3);
        out.add(MATH_QUESTION_4);
        out.add(MATH_QUESTION_5);
        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldAddReturnQuestionCorrect() {
        assertEquals(MATH_QUESTION_1, out.add(MATH_QUESTION_1));
    }

    @Test
    void shouldRemoveWorkCorrect() {
        out.add(MATH_QUESTION_1);
        out.add(MATH_QUESTION_2);
        out.add(MATH_QUESTION_3);
        out.add(MATH_QUESTION_4);
        out.add(MATH_QUESTION_5);
        out.remove(MATH_QUESTION_5);
        out.remove(MATH_QUESTION_5);
        out.remove(MATH_QUESTION_4);
        expected.remove(MATH_QUESTION_5);
        expected.remove(MATH_QUESTION_4);
        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldRemoveReturnQuestionCorrect() {
        assertEquals(MATH_QUESTION_1, out.remove(MATH_QUESTION_1));
    }

    @Test
    void shouldGetAllWorkCorrect() {
        out.add(MATH_QUESTION_1);
        out.add(MATH_QUESTION_2);
        out.add(MATH_QUESTION_3);
        out.add(MATH_QUESTION_4);
        out.add(MATH_QUESTION_5);
        assertEquals(expected, out.getAll());
    }
}