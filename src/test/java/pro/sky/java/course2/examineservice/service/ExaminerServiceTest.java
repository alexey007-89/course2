package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.NotValidAmountOfQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {
    Collection<Question> expectedJavaQuestions = new HashSet<>();
    Collection<Question> expectedMathQuestions = new HashSet<>();

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        expectedJavaQuestions.add(JAVA_QUESTION_1);
        expectedJavaQuestions.add(JAVA_QUESTION_2);
        expectedJavaQuestions.add(JAVA_QUESTION_3);
        expectedMathQuestions.add(MATH_QUESTION_1);
        expectedMathQuestions.add(MATH_QUESTION_2);
        expectedMathQuestions.add(MATH_QUESTION_3);
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountEqualsSizeOfSet() {
        expectedJavaQuestions.add(JAVA_QUESTION_1);
        expectedJavaQuestions.add(JAVA_QUESTION_2);
        expectedJavaQuestions.add(JAVA_QUESTION_3);
        expectedMathQuestions.add(MATH_QUESTION_1);
        expectedMathQuestions.add(MATH_QUESTION_2);
        expectedMathQuestions.add(MATH_QUESTION_3);
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expectedJavaQuestions);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(expectedMathQuestions);
        expectedJavaQuestions.addAll(expectedMathQuestions);
        assertEquals(expectedJavaQuestions, out.getQuestion(6));
    }

    @Test
    void shouldGetQuestionThrowsNotValidAmountOfQuestionsExceptionWhenAmountNotValid() {
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expectedJavaQuestions);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(expectedMathQuestions);
        assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestion(-1));
        assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestion(7));
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountDoNotEqualsSizeOfSet() {
        Collection<Question> expected1 = Set.of(JAVA_QUESTION_1, JAVA_QUESTION_2,
                JAVA_QUESTION_3, JAVA_QUESTION_4, JAVA_QUESTION_5);
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expected1);
        Collection<Question> expected2 = Set.of(MATH_QUESTION_1, MATH_QUESTION_2, MATH_QUESTION_3, MATH_QUESTION_4);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(expected2);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(JAVA_QUESTION_1, JAVA_QUESTION_2, JAVA_QUESTION_3);
        when(mathQuestionServiceMock.getRandomQuestion())
                .thenReturn(MATH_QUESTION_1, MATH_QUESTION_2, MATH_QUESTION_3);
        expectedJavaQuestions.addAll(expectedMathQuestions);
        assertEquals(expectedJavaQuestions, out.getQuestion(6));
        verify(javaQuestionServiceMock, times(3)).getRandomQuestion();
        verify(mathQuestionServiceMock, times(3)).getRandomQuestion();
    }
}