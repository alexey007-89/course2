package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void shouldAddByQuestionAndAnswerWorkCorrect() {
        when(mathQuestionRepositoryMock.add(MATH_QUESTION_1))
                .thenReturn(MATH_QUESTION_1);
        assertEquals(MATH_QUESTION_1, out.add(MATH_QUESTION_1.getQuestion(), MATH_QUESTION_1.getAnswer()));
        verify(mathQuestionRepositoryMock, times(1)).add(MATH_QUESTION_1);
    }

    @Test
    void shouldAddWorkCorrect() {
        when(mathQuestionRepositoryMock.add(MATH_QUESTION_1))
                .thenReturn(MATH_QUESTION_1);
        assertEquals(MATH_QUESTION_1, out.add(MATH_QUESTION_1));
        verify(mathQuestionRepositoryMock, times(1)).add(MATH_QUESTION_1);
    }

    @Test
    void shouldRemoveWorkCorrect() {
        when(mathQuestionRepositoryMock.remove(MATH_QUESTION_1))
                .thenReturn(MATH_QUESTION_1);
        assertEquals(MATH_QUESTION_1, out.remove(MATH_QUESTION_1));
        verify(mathQuestionRepositoryMock, times(1)).remove(MATH_QUESTION_1);
    }

    @Test
    void shouldGetAllWorkCorrect() {
        Collection<Question> expected = new HashSet<>();
        expected.add(MATH_QUESTION_1);
        expected.add(MATH_QUESTION_2);
        expected.add(MATH_QUESTION_3);
        expected.add(MATH_QUESTION_4);
        expected.add(MATH_QUESTION_5);
        when(mathQuestionRepositoryMock.getAll())
                .thenReturn(expected);
        assertEquals(expected, out.getAll());
    }

}