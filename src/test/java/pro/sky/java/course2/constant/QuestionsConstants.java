package pro.sky.java.course2.constant;

import pro.sky.java.course2.examineservice.domain.Question;

public class QuestionsConstants {
    public static final Question JAVA_QUESTION_1 = new Question("Что такое цикл?",
            "Конструкция языка, позволяющая выполнять один и тот же код многократно в зависимости от условий");
    public static final Question JAVA_QUESTION_2 = new Question("Что такое Commit?",
            "Запись в истории изменений, которая содержит commit message (описание внесенных изменений)," +
                    " а также содержит обновленные файлы, подвергшиеся изменениям");
    public static final Question JAVA_QUESTION_3 = new Question("Что такое строка?",
            "Неизменяемый массив символов");
    public static final Question JAVA_QUESTION_4 = new Question("Что такое массив?",
            "Упорядоченная структура данных фиксированного размера");
    public static final Question JAVA_QUESTION_5 = new Question("Что такое инкапсуляция?",
            "Это механизм языка, позволяющий ограничить прямой доступ к полям и методам класса извне " +
                    "(другим классам), с целью запретить бесконтрольную модификацию состояния объекта " +
                    "или вызов методов, которые также могут изменить его состояние");
    public static final Question MATH_QUESTION_1 = new Question("2+2", "4");
    public static final Question MATH_QUESTION_2 = new Question("2*5", "10");
    public static final Question MATH_QUESTION_3 = new Question("100/4", "25");
    public static final Question MATH_QUESTION_4 = new Question("3*100", "300");
    public static final Question MATH_QUESTION_5 = new Question("1+2+3+4+5", "15");
}
