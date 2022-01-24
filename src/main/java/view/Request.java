package view;

import model.RequestType;

import java.util.Scanner;

public class Request {
//    private static String command;
//    public static String getCommand() {
//        return command;
//    }
//
//    public static void getNewCommand(String command) { command = command;
//    }

    public static RequestType getType(String command) {
        if (command == null || command.equals("")) {
            return null;
        } else if (command.matches("user create --username <(?<userName>.+)> -- password1 <(?<passWord1>\\S+)> --password2 <(?<passWord2>\\S+)> --email Address <(?<email>.+)> --birthday <(?<birthday>\\.+)>$")){
            return RequestType.USER_CREATE;
        } else if (command.matches("user login --username <(?<userName>.+)> --password <(?<passWord>\\S+)>")){
            return RequestType.USER_LOGIN;
        } else if (command.matches("enter menu <(?<menuName>.+)>")) {
            return RequestType.ENTER_MENU;
        } else if (command.matches("profile --change --oldPassword <(?<oldPass>\\S+)> --newPassword <(?<newPass>\\S+)>")) {
            return RequestType.CHANGE_PASSWORD;
        } else if (command.matches("profile --change --username <(?<newUserName>\\S+)>")){
            return RequestType.CHANGE_USERNAME;
        } else if (command.matches("profile --showTeams")){
            return RequestType.SHOW_MY_TEAMS;
        } else if (command.matches("profile --showTeam <(?<teamName>.+)>")){
            return RequestType.SHOW_TEAM_NAME;
        } else if (command.matches("profile --show --myProfile")){
            return RequestType.SHOW_MY_PROFILE;
        } else if (command.matches("profile --show logs")){
            return RequestType.SHOW_LOGS;
        } else if (command.matches("profile --show notifications")){
            return RequestType.SHOW_NOTIFICATIONS;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --title (\\[)(?<newTitle>.+)(\\])")){
            return RequestType.EDIT_TASK_TITLE;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --description (\\[)(?<newDescription>.+)(\\])")){
            return RequestType.EDIT_TASK_DESCRIPTIONS;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --priority (\\])(?<newPeriority>.+)(\\])")){
            return RequestType.EDIT_TASK_PRIORITY;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --Deadline (\\[)(?<newDeadLine>.+)(\\])")){
            return RequestType.EDIT_TASK_DEADLINE;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --assignedUsers <(?<userNames>.+)> --remove")){
            return RequestType.REMOVE_ASSIGNED_USERS;
        } else if (command.matches("edit --task --id (\\[)(?<taskId>\\S+)(\\]) --assignedUsers <(?<userNames>.+)> --add")){
            return RequestType.ADD_ASSIGNED_USERS;
        } else if (command.matches("Enter team <(?<teamName>.+)>")){
            return RequestType.ENTER_TEAM;
        } else if (command.matches("Scoreboard --show")){
            return RequestType.SCOREBOARD_SHOW;
        } else if (command.matches("Roadmap --show")){
            return  RequestType.ROADMAP_SHOW;
        } else if (command.matches("Cahtroom --show")){
            return RequestType.CHATROOM_SHOW;
        } else if (command.matches("send --message <(?<message>.+)>")){
            return RequestType.SEND_MESSAGE;
        } else if (command.matches("show tasks")){
            return RequestType.SHOW_TASKS;
        } else if (command.matches("show task --id (\\[)(?<taskId>\\S+)(\\])")){
            return RequestType.SHOW_TASK_ID;
        } else if (command.matches("board --new --name <(?<boardName>.+)>")){
            return RequestType.NEW_BOARD;
        }
            return null;
    }
}
