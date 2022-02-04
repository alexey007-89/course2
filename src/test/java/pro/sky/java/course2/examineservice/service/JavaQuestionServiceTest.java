package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.QuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    void shouldAddByQuestionAndAnswerWorkCorrect() {
        when(javaQuestionRepositoryMock.add(JAVA_QUESTION_1))
                .thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, out.add(JAVA_QUESTION_1.getQuestion(), JAVA_QUESTION_1.getAnswer()));
        verify(javaQuestionRepositoryMock, times(1)).add(JAVA_QUESTION_1);
    }

    @Test
    void shouldAddWorkCorrect() {
        when(javaQuestionRepositoryMock.add(JAVA_QUESTION_1))
                .thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, out.add(JAVA_QUESTION_1));
        verify(javaQuestionRepositoryMock, times(1)).add(JAVA_QUESTION_1);
    }

    @Test
    void shouldRemoveWorkCorrect() {
        when(javaQuestionRepositoryMock.remove(JAVA_QUESTION_1))
                .thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, out.remove(JAVA_QUESTION_1));
        verify(javaQuestionRepositoryMock, times(1)).remove(JAVA_QUESTION_1);
    }

    @Test
    void shouldGetAllWorkCorrect() {
        Collection<Question> expected = new HashSet<>();
        expected.add(JAVA_QUESTION_1);
        expected.add(JAVA_QUESTION_2);
        expected.add(JAVA_QUESTION_3);
        expected.add(JAVA_QUESTION_4);
        expected.add(JAVA_QUESTION_5);
        when(javaQuestionRepositoryMock.getAll())
                .thenReturn(expected);
        assertEquals(expected, out.getAll());
    }

}