package view;

import model.Notification;
import model.SystemAdmin;
import model.TeamLeader;

public class SystemAdminMainMenu extends MainMenu{
    public SystemAdminMainMenu(SystemAdmin systemAdmin){
        super(systemAdmin);
    }
    public void watchATeamMemberProfile(String userName){

    }
    public void removeATeamMember(String userName){

    }
    public void changeRole(String userName , String newRole){

    }

    public void sendNotification(Notification notification){

    }
    public void sendNotificationToAUser(Notification notification , String userName){

    }
    public void sendNotificationToATeam(Notification notification , String userName){

    }

    public void showScoreBoard(){

    }

    public void showRequestedTeams(){

    }

    public void acceptTeams(String teamNames){

    }

    public void rejectTeams(String teamNames){

    }
}
