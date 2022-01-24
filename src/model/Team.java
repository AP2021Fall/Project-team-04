package model;

import java.util.ArrayList;

public class Team{
    private String teamName;
    private String teamLeaderName;
    private ArrayList<UserKamyar> teamMembers = new ArrayList<>();
    private ArrayList<Task> teamsTasks = new ArrayList<>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName;
    }

    public int getTeamMembersCount(){
        return teamMembers.size();
    }

    public UserKamyar getTeamMemberName(int i){
        return teamMembers.get(i);
    }

    public void addTeamMembers(UserKamyar user){
        teamMembers.add(user);
    }

    public int getTeamTasksCount(){
        return teamsTasks.size();
    }

    public Task getTeamTasks(int i){
        return teamsTasks.get(i);
    }

    public void addTeamTasks(Task task){
        teamsTasks.add(task);
    }
}
