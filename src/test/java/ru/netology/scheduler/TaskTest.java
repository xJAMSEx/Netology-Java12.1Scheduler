package ru.netology.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void matchesTestSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTestSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("позвонить");
        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesTestEpicFalse() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("сок");
        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesTestEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesTestMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("версии");
        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesTestMeetingTopicFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("версия");
        Assertions.assertFalse(actual);
    }

    @Test
    public void matchesTestMeetingProjectTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    void testEquals() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        boolean actual = simpleTask.equals("0");
        Assertions.assertFalse(actual);
    }

}