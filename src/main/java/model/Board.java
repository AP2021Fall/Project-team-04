package model;

import java.util.ArrayList;

public class Board {
    public static ArrayList<Board> boards = new ArrayList<>();
    private String boardName;
    private ArrayList<Column> columns = new ArrayList<>();
    private String status;
    private Team team;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Board(String boardName){
        this.boardName = boardName;
    }

    public static void getBoardByName(String boardName){

    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public void addTask(Task task){
        tasks.add(task);
    }
}
