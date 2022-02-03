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
    Collection<Question> expected = new HashSet<>();

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        expected.add(QUESTION_1);
        expected.add(QUESTION_2);
        expected.add(QUESTION_3);
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountEqualsSizeOfSet() {
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expected);
        assertEquals(expected, out.getQuestion(3));
        verify(javaQuestionServiceMock, times(3)).getAll();
    }

    @Test
    void shouldGetQuestionThrowsNotValidAmountOfQuestionsExceptionWhenAmountNotValid() {
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expected);
        assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestion(-1));
        assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestion(4));
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountDoNotEqualsSizeOfSet() {
        Collection<Question> expected2 = Set.of(QUESTION_1,QUESTION_2,QUESTION_3,QUESTION_4);
        when(javaQuestionServiceMock.getAll())
                .thenReturn(expected2);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3);
        assertEquals(expected, out.getQuestion(3));
        verify(javaQuestionServiceMock, times(3)).getRandomQuestion();
    }
}