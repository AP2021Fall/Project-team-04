package view;

import model.Task;
import model.TeamLeader;
import model.User;

import java.net.UnknownServiceException;

public class BoardMenu {
    private TeamLeader teamLeader;
    private User user;
    private String processBoardName;
    public BoardMenu(TeamLeader teamLeader){
        this.teamLeader = teamLeader;
    }

    public BoardMenu(User user){
        this.user = user;
    }

    public void selectBoard(String boardName){

    }

    public void deselectBoard(){

    }

    public void makeBoard(String name){

    }

    public void removeBoard(String name){

    }

    public void addTask(int taskId , String boardName){

    }
    public void assignTaskToTeamMember(String teamMemberName , int taskId , String boardName){

    }

    public void forceToCategory(String category , String taskTitle , String boardName){

    }

    public void goToNextTask(int taskId , String boardName){

    }

    public void showTasks(){

    }
    public void showFailedOrDoneTAsks(String status , String boardName){

    }

    public void pushTasksToFromFailed(String taskTitle , String deadLine , String boardName){

    }

    public void pushTasksToFromFailed(String taskTitle , String teamMember  , String deadLine , String categoryName , String boardName){

    }
    public void showBoardDetails(String boardName){

    }
}
