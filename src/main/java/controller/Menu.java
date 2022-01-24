//package controller;
//import model.RequestType;
//import model.Team;
//import model.User;
//import view.Request;
//
////import java.swing.*;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//
//public class Menu {
//    ArrayList<User> users = new ArrayList<>();
//    ArrayList<Team> teams = new ArrayList<>();
//    boolean isLogin = false;
//    boolean profileMenu = false;
//    boolean teamMenu = false;
//    boolean tasksPage = false;
//    boolean calendarMenu = false;
//    boolean notificationBar = false;
//    int loggedInUserIndex;
//    int wrongPassWordCount = 0;
//
//    public void main() {
//        boolean isFinish = false;
//        do {
//            Request request = new Request();
//            request.getNewCommand();
//            if (request.getType() == RequestType.USER_CREATE){
//                userCreate(request);
//            } else if (request.getType() == RequestType.USER_LOGIN){
//                userLogin(request);
//            } else if (request.getType() == RequestType.ENTER_MENU){
//                enterMenu(request);
//            } else if (request.getType() == RequestType.CHANGE_PASSWORD){
//                changePassWord(request);
//            } else if (request.getType() == RequestType.CHANGE_USERNAME){
//                changeUserName(request);
//            } else if (request.getType() == RequestType.SHOW_MY_TEAMS){
//                showMyTeams(request);
//            } else if (request.getType() == RequestType.SHOW_TEAM_NAME){
//                showTeamName(request);
//            } else if (request.getType() == RequestType.SHOW_MY_PROFILE){
//                showMyProfile(request);
//            } else if (request.getType() == RequestType.SHOW_LOGS){
//                showLogs(request);
//            } else if (request.getType() == RequestType.SHOW_NOTIFICATIONS){
//                showNotifications(request);
//            } else if (request.getType() == RequestType.EDIT_TASK_TITLE){
//                editTitle(request);
//            } else if (request.getType() == RequestType.EDIT_TASK_DESCRIPTIONS){
//                editDescription(request);
//            } else if (request.getType() == RequestType.EDIT_TASK_PRIORITY){
//                editPriority(request);
//            } else if (request.getType() == RequestType.EDIT_TASK_DEADLINE){
//                editDeadLine(request);
//            } else if (request.getType() == RequestType.ADD_ASSIGNED_USERS){
//                addAssignedUser(request);
//            } else if (request.getType() == RequestType.REMOVE_ASSIGNED_USERS){
//                removeAssignedUser(request);
//            }
//        }
//    }
//
//    public void userCreate(Request request) {
//        if (!isLogin) {
//            boolean isUserNameExist = false;
//            boolean isEmailExist = false;
//            String userName = request.getCommand().split("<")[1];
//            String password1 = request.getCommand().split("<")[2];
//            String password2 = request.getCommand().split("<")[3];
//            String email = request.getCommand().split("<")[4];
//            for (int i = 0; i < users.size(); i++) {
//                if (userName.equals(users.get(i).getUserName())) {
//                    isUserNameExist = true;
//                    break;
//                }
//            }
//            for (int j = 0; j < users.size(); j++) {
//                if (email.equals(users.get(j).getEmail())) {
//                    isEmailExist = true;
//                    break;
//                }
//            }
//            if (isUserNameExist) {
//                System.out.println("user with username" + " " + "<" + userName + ">" + " " + "already exists!");
//            } else if (!(password1.equals(password2))) {
//                System.out.println("Your passwords are not the same!");
//            } else if (isEmailExist) {
//                System.out.println("User with this email already exists!");
//            } else if (!email.matches("[a-zA-Z0-9.]+@(yahoo.com|gmail.com)")) {
//                System.out.println("Email address is invalid!");
//            } else {
//                System.out.println("user created successfully!");
//                users.add(new User(userName, password1, email, "team member"));
//                users.get(users.size() - 1).addUserAllPassWords(password1);
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void userLogin(Request request) {
//        if (!isLogin) {
//            int i;
//            boolean isUserExists = false;
//            String userName = request.getCommand().split("<")[1];
//            String passWord = request.getCommand().split("<")[2];
//            for (i = 0; i < users.size(); i++) {
//                if (userName.equals(users.get(i).getUserName())) {
//                    isUserExists = true;
//                    break;
//                }
//            }
//            if (!isUserExists) {
//                System.out.println("There is not any user with username:" + " " + "<" + userName + ">" + "!");
//            } else if (!passWord.equals(users.get(i).getPassWord())) {
//                System.out.println("Username and password didn't match!");
//            } else {
//                System.out.println("user logged in successfully!");
//                isLogin = true;
//                loggedInUserIndex = i;
//                System.out.println("1: Profile Menu");
//                System.out.println("2: Team Menu --> { Chat Room - Board Menu - ScoreBoard - RoadMaps }");
//                System.out.println("3: Tasks Page");
//                System.out.println("4: Calendar Menu");
//                System.out.println("5: Notification Bar");
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void enterMenu(Request request){
//        String menuName = request.getCommand().split("<")[1];
//        switch (menuName){
//            case "Profile Menu": profileMenu = true;
//            case "Team Menu": teamMenu = true;
//            case "Tasks Page": tasksPage = true;
//            case "Calendar Menu": calendarMenu = true;
//            case "Notification Bar": notificationBar = true;
//            default:
//                System.out.println("invalid command!");
//        }
//    }
//
//    public void changePassWord(Request request){
//        if (profileMenu){
//            boolean isPassWordSameWithOneOfOlds = false;
//            String oldPassWord = request.getCommand().split("<")[1];
//            String newPassWord = request.getCommand().split("<")[2];
//            if (!oldPassWord.equals(users.get(loggedInUserIndex).getPassWord())){
//                System.out.println("wrong old password!");
//                if (wrongPassWordCount == 0) {
//                    wrongPassWordCount++;
//                } else if (wrongPassWordCount == 1){
//                    System.out.println("wrong old password!");
//                    isLogin = false;
//                    wrongPassWordCount = 0;
//                }
//            } else {
//                for (int i1 = 0 ; i1 < users.get(loggedInUserIndex).getUserAllPassWordsSize() ; i1++){
//                    if (newPassWord.equals(users.get(loggedInUserIndex).getUserAllPassWords(i1))){
//                        isPassWordSameWithOneOfOlds = true;
//                        break;
//                    }
//                }
//                if (isPassWordSameWithOneOfOlds){
//                    System.out.println("Please type a New Password !");
//                } else if ((!newPassWord.matches("[A-Z0-9]+\\S+")) || newPassWord.length() < 8){
//                    System.out.println("Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)");
//                } else {
//                    System.out.println("new password set successfully");
//                    users.get(loggedInUserIndex).addUserAllPassWords(newPassWord);
//                    users.get(loggedInUserIndex).setPassWord(newPassWord);
//                }
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void changeUserName(Request request) {
//        if (isLogin && profileMenu) {
//            String newUserName = request.getCommand().split("<")[1];
//            boolean isNewUserNameExists = false;
//            for (int j = 0; j < users.size(); j++) {
//                if (newUserName.equals(users.get(j).getUserName())) {
//                    isNewUserNameExists = true;
//                    break;
//                }
//            }
//            if (newUserName.length() < 4) {
//                System.out.println("Your new username must include at least 4 characters!");
//            } else if (isNewUserNameExists) {
//                System.out.println("username already taken!");
//            } else if (!newUserName.matches("[A-Za-z0-9_]+")) {
//                System.out.println("New username contains Special Characters! Please remove them and try again");
//            } else if (newUserName.equals(users.get(loggedInUserIndex).getUserName())) {
//                System.out.println("you already have this username !");
//            } else {
//                System.out.println("new username set successfully");
//                users.get(loggedInUserIndex).setUserName(newUserName);
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void showMyTeams(Request request){
//        if (isLogin && profileMenu){
//            for (int j = users.get(loggedInUserIndex).getUsersTeamsCount() - 1 ; j >= 0  ; j--){
//                System.out.println(users.get(loggedInUserIndex).getUsersTeamsName(j));
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void showTeamName(Request request) {
//        if (isLogin && profileMenu) {
//            String teamName = request.getCommand().split("<")[1];
//            int j;
//            for (j = 0; j < teams.size(); j++) {
//                if (teamName.equals(teams.get(j).getTeamName())) {
//                    String[] teamMembersName = new String[teams.get(j).getTeamMembersCount()];
//                    for (int i1 = 0 ; i1 < teams.get(j).getTeamMembersCount() ; i1++){
//                        teamMembersName[i1] = teams.get(j).getTeamMemberName(i1);
//                    }
//                    Arrays.sort(teamMembersName);
//                    System.out.println(teamName);
//                    System.out.println(teams.get(j).getTeamLeaderName());
//                    if (users.get(loggedInUserIndex).getUserName().equals(teams.get(j).getTeamLeaderName())) {
//                        for (int j1 = 0; j1 < teams.get(j).getTeamMembersCount(); j1++) {
//                            System.out.println(teamMembersName[j1]);
//                        }
//                    } else {
//                        System.out.println(users.get(loggedInUserIndex).getUserName());
//                        for (int j1 = 0; j1 < teams.get(j).getTeamMembersCount(); j1++) {
//                            if (!teams.get(j).getTeamMemberName(j1).equals(users.get(loggedInUserIndex).getUserName())) {
//                                System.out.println(teamMembersName[j1]);
//                            }
//                        }
//                    }
//                    break;
//                }
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void showMyProfile(Request request) {
//        if (isLogin && profileMenu) {
//            System.out.println(users.get(loggedInUserIndex).getFullName());
//            System.out.println(users.get(loggedInUserIndex).getUserName());
//            System.out.println(users.get(loggedInUserIndex).getBirthDayDate());
//            System.out.println(users.get(loggedInUserIndex).getEmail());
//            System.out.println(users.get(loggedInUserIndex).getRole());
//            System.out.println(users.get(loggedInUserIndex).getScore());
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void showLogs(Request request){
//
//    }
//
//    public void showNotifications(Request request) {
//        if (isLogin && profileMenu) {
//            for (int j = 0; j < users.get(loggedInUserIndex).getNotificationsCount(); j++) {
//                System.out.println(users.get(loggedInUserIndex).getNotifications(j));
//            }
//        } else
//            System.out.println("invalid command!");
//    }
//
//    public void editTitle(Request request){
//
//    }
//
//    public void editDescription(Request request){
//
//    }
//
//    public void editPriority(Request request){
//
//    }
//
//    public void editDeadLine(Request request){
//
//    }
//
//    public void addAssignedUser(Request request){
//
//    }
//
//    public void removeAssignedUser(Request request){
//
//    }
//}
