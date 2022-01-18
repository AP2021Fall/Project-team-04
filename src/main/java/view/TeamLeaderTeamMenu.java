package view;

import model.Notification;
import model.TeamLeader;
import model.User;

public class TeamLeaderTeamMenu extends TeamMenu {
    public TeamLeaderTeamMenu(TeamLeader teamLeader){
        super(teamLeader);
    }
    public void showAllTasks(){

    }

    public void makeNewTask(String taskTitle , String startTime , String deadLine){

    }

    public void showAllMembers(){

    }
    public void addMember(String userName){

    }

    public void deleteMember(String userName){

    }

    public void suspendMember(String userName){

    }

    public void promoteTeamMemberToTeamLeader(String userName , int rate){

    }
    public void assignMemberToTask(int taskId , String userName){

    }
    public void showScoreBoard(){

    }
    public void sendNotificationToAUser(Notification notification , String userName){

    }
    public void sendNotificationToATeam(Notification notification , String userName){

    }


}
