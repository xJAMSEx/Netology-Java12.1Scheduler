package ru.netology.scheduler;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String subtasks[]) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {

        for (String subtask : subtasks) {
            if (subtask.contains(query))
                return true;
        }
        return false;
    }
}