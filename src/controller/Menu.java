package controller;

import model.*;
import view.Request;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    ArrayList<UserKamyar> users = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();
    boolean isLogin = false;
    boolean profileMenu = false;
    boolean teamMenu = false;
    boolean tasksPage = false;
    boolean calendarMenu = false;
    boolean notificationBar = false;
    int loggedInUserIndex;
    int wrongPassWordCount = 0;
    int myTeamNumber;


    public void main() {
        boolean isFinish = false;
        do {
            Request request = new Request();
            request.getNewCommand();
            if (request.getType() == RequestType.USER_CREATE) {
                userCreate(request);
            } else if (request.getType() == RequestType.USER_LOGIN) {
                userLogin(request);
            } else if (request.getType() == RequestType.ENTER_MENU) {
                enterMenu(request);
            } else if (request.getType() == RequestType.CHANGE_PASSWORD) {
                changePassWord(request);
            } else if (request.getType() == RequestType.CHANGE_USERNAME) {
                changeUserName(request);
            } else if (request.getType() == RequestType.SHOW_MY_TEAMS) {
                showMyTeams(request);
            } else if (request.getType() == RequestType.SHOW_TEAM_NAME) {
                showTeamName(request);
            } else if (request.getType() == RequestType.SHOW_MY_PROFILE) {
                showMyProfile(request);
            } else if (request.getType() == RequestType.SHOW_LOGS) {
                showLogs(request);
            } else if (request.getType() == RequestType.SHOW_NOTIFICATIONS) {
                showNotifications(request);
            } else if (request.getType() == RequestType.EDIT_TASK_TITLE) {
                editTitle(request);
            } else if (request.getType() == RequestType.EDIT_TASK_DESCRIPTIONS) {
                editDescription(request);
            } else if (request.getType() == RequestType.EDIT_TASK_PRIORITY) {
                editPriority(request);
            } else if (request.getType() == RequestType.EDIT_TASK_DEADLINE) {
                editDeadLine(request);
            } else if (request.getType() == RequestType.ADD_ASSIGNED_USERS) {
                addAssignedUser(request);
            } else if (request.getType() == RequestType.REMOVE_ASSIGNED_USERS) {
                removeAssignedUser(request);
            } else if (request.getType() == RequestType.ENTER_TEAM){
                enterTeam(request);
            } else if (request.getType() == RequestType.SCOREBOARD_SHOW){
                scoreBoardShow(request);
            } else if (request.getType() == RequestType.ROADMAP_SHOW){
                roadMapShow(request);
            } else if (request.getType() == RequestType.CHATROOM_SHOW){
                chatRoomShow(request);
            } else if (request.getType() == RequestType.SEND_MESSAGE){
                sendMessage(request);
            }
        } while (!isFinish);
    }

    public void userCreate(Request request) {
        if (!isLogin) {
            boolean isUserNameExist = false;
            boolean isEmailExist = false;
            String userName = request.getCommand().split("<")[1].split(">")[0];
            String password1 = request.getCommand().split("<")[2].split(">")[0];
            String password2 = request.getCommand().split("<")[3].split(">")[0];
            String email = request.getCommand().split("<")[4].split(">")[0];
            for (int i = 0; i < users.size(); i++) {
                if (userName.equals(users.get(i).getUserName())) {
                    isUserNameExist = true;
                    break;
                }
            }
            for (int j = 0; j < users.size(); j++) {
                if (email.equals(users.get(j).getEmail())) {
                    isEmailExist = true;
                    break;
                }
            }
            if (isUserNameExist) {
                System.out.println("user with username" + " " + "<" + userName + ">" + " " + "already exists!");
            } else if (!(password1.equals(password2))) {
                System.out.println("Your passwords are not the same!");
            } else if (isEmailExist) {
                System.out.println("User with this email already exists!");
            } else if (!email.matches("[a-zA-Z0-9.]+@(yahoo.com|gmail.com)")) {
                System.out.println("Email address is invalid!");
            } else {
                System.out.println("user created successfully!");
                users.add(new UserKamyar(userName, password1, email, "team member"));
                users.get(users.size() - 1).addUserAllPassWords(password1);
            }
        } else
            System.out.println("invalid command!");
    }

    public void userLogin(Request request) {
        if (!isLogin) {
            int i;
            boolean isUserExists = false;
            String userName = request.getCommand().split("<")[1].split(">")[0];
            String passWord = request.getCommand().split("<")[2].split(">")[0];
            for (i = 0; i < users.size(); i++) {
                if (userName.equals(users.get(i).getUserName())) {
                    isUserExists = true;
                    break;
                }
            }
            if (!isUserExists) {
                System.out.println("There is not any user with username:" + " " + "<" + userName + ">" + "!");
            } else if (!passWord.equals(users.get(i).getPassWord())) {
                System.out.println("Username and password didn't match!");
            } else {
                System.out.println("user logged in successfully!");
                isLogin = true;
                Date dNow = new Date();
                SimpleDateFormat logDateFormat = new SimpleDateFormat("E yyy.MM.dd 'at' hh:mm:ss a");
                users.get(i).addLogs(logDateFormat.format(dNow));
                loggedInUserIndex = i;
                System.out.println("1: Profile Menu");
                System.out.println("2: Team Menu --> { Chat Room - Board Menu - ScoreBoard - RoadMaps }");
                System.out.println("3: Tasks Page");
                System.out.println("4: Calendar Menu");
                System.out.println("5: Notification Bar");
            }
        } else
            System.out.println("invalid command!");
    }

    public void enterMenu(Request request) {
        String menuName = request.getCommand().split("<")[1].split(">")[0];
        switch (menuName) {
            case "Profile Menu": {
                profileMenu = true;
                teamMenu = false;
                tasksPage = false;
                calendarMenu = false;
                notificationBar = false;
            }
            case "Team Menu": {
                profileMenu = false;
                tasksPage = false;
                calendarMenu = false;
                notificationBar = false;
                teamMenu();
            }
            case "Tasks Page": {
                tasksPage = true;
                teamMenu = false;
                profileMenu = false;
                calendarMenu = false;
                notificationBar = false;
                taskPage();
            }
            case "Calendar Menu": {
                calendarMenu = true;
                tasksPage = false;
                teamMenu = false;
                profileMenu = false;
                notificationBar = false;
            }
            case "Notification Bar": {
                notificationBar = true;
                calendarMenu = false;
                tasksPage = false;
                teamMenu = false;
                profileMenu = false;
            }
            default:
                System.out.println("invalid command!");
        }
    }

    public void changePassWord(Request request) {
        if (profileMenu) {
            boolean isPassWordSameWithOneOfOlds = false;
            String oldPassWord = request.getCommand().split("<")[1].split(">")[0];
            String newPassWord = request.getCommand().split("<")[2].split(">")[0];
            if (!oldPassWord.equals(users.get(loggedInUserIndex).getPassWord())) {
                System.out.println("wrong old password!");
                if (wrongPassWordCount == 0) {
                    wrongPassWordCount++;
                } else if (wrongPassWordCount == 1) {
                    System.out.println("wrong old password!");
                    isLogin = false;
                    wrongPassWordCount = 0;
                }
            } else {
                for (int i1 = 0; i1 < users.get(loggedInUserIndex).getUserAllPassWordsSize(); i1++) {
                    if (newPassWord.equals(users.get(loggedInUserIndex).getUserAllPassWords(i1))) {
                        isPassWordSameWithOneOfOlds = true;
                        break;
                    }
                }
                if (isPassWordSameWithOneOfOlds) {
                    System.out.println("Please type a New Password !");
                } else if ((!newPassWord.matches("[A-Z0-9]+\\S+")) || newPassWord.length() < 8) {
                    System.out.println("Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)");
                } else {
                    System.out.println("new password set successfully");
                    users.get(loggedInUserIndex).addUserAllPassWords(newPassWord);
                    users.get(loggedInUserIndex).setPassWord(newPassWord);
                }
            }
        } else
            System.out.println("invalid command!");
    }

    public void changeUserName(Request request) {
        if (isLogin && profileMenu) {
            String newUserName = request.getCommand().split("<")[1].split(">")[0];
            boolean isNewUserNameExists = false;
            for (int j = 0; j < users.size(); j++) {
                if (newUserName.equals(users.get(j).getUserName())) {
                    isNewUserNameExists = true;
                    break;
                }
            }
            if (newUserName.length() < 4) {
                System.out.println("Your new username must include at least 4 characters!");
            } else if (isNewUserNameExists) {
                System.out.println("username already taken!");
            } else if (!newUserName.matches("[A-Za-z0-9_]+")) {
                System.out.println("New username contains Special Characters! Please remove them and try again");
            } else if (newUserName.equals(users.get(loggedInUserIndex).getUserName())) {
                System.out.println("you already have this username !");
            } else {
                System.out.println("new username set successfully");
                users.get(loggedInUserIndex).setUserName(newUserName);
            }
        } else
            System.out.println("invalid command!");
    }

    public void showMyTeams(Request request) {
        if (isLogin && profileMenu) {
            for (int j = users.get(loggedInUserIndex).getUsersTeamsCount() - 1; j >= 0; j--) {
                System.out.println(users.get(loggedInUserIndex).getUsersTeamsName(j));
            }
        } else
            System.out.println("invalid command!");
    }

    public void showTeamName(Request request) {
        if (isLogin && profileMenu) {
            String teamName = request.getCommand().split("<")[1].split(">")[0];
            int j;
            for (j = 0; j < teams.size(); j++) {
                if (teamName.equals(teams.get(j).getTeamName())) {
                    String[] teamMembersName = new String[teams.get(j).getTeamMembersCount()];
                    for (int i1 = 0; i1 < teams.get(j).getTeamMembersCount(); i1++) {
                        teamMembersName[i1] = teams.get(j).getTeamMemberName(i1).getUserName();
                    }
                    Arrays.sort(teamMembersName);
                    System.out.println(teamName);
                    System.out.println(teams.get(j).getTeamLeaderName());
                    if (users.get(loggedInUserIndex).getUserName().equals(teams.get(j).getTeamLeaderName())) {
                        for (int j1 = 0; j1 < teams.get(j).getTeamMembersCount(); j1++) {
                            System.out.println(teamMembersName[j1]);
                        }
                    } else {
                        System.out.println(users.get(loggedInUserIndex).getUserName());
                        for (int j1 = 0; j1 < teams.get(j).getTeamMembersCount(); j1++) {
                            if (!teams.get(j).getTeamMemberName(j1).equals(users.get(loggedInUserIndex).getUserName())) {
                                System.out.println(teamMembersName[j1]);
                            }
                        }
                    }
                    break;
                }
            }
        } else
            System.out.println("invalid command!");
    }

    public void showMyProfile(Request request) {
        if (isLogin && profileMenu) {
            System.out.println(users.get(loggedInUserIndex).getFullName());
            System.out.println(users.get(loggedInUserIndex).getUserName());
            System.out.println(users.get(loggedInUserIndex).getBirthDayDate());
            System.out.println(users.get(loggedInUserIndex).getEmail());
            System.out.println(users.get(loggedInUserIndex).getRole());
            System.out.println(users.get(loggedInUserIndex).getScore());
        } else
            System.out.println("invalid command!");
    }

    public void showLogs(Request request) {
        if (isLogin && profileMenu){
            for (int i = 0 ; i < users.get(loggedInUserIndex).getLogsCount() ; i++){
                System.out.println(users.get(loggedInUserIndex).getLogs(i));
            }
        }
    }

    public void showNotifications(Request request) {
        if (isLogin && profileMenu) {
            for (int j = 0; j < users.get(loggedInUserIndex).getNotificationsCount(); j++) {
                System.out.println(users.get(loggedInUserIndex).getNotifications(j));
            }
        } else
            System.out.println("invalid command!");
    }

    public void taskPage() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("ID: " + tasks.get(i).getId());
            System.out.println("Title: " + tasks.get(i).getTitle());
            System.out.println("Description: " + tasks.get(i).getDescription());
            System.out.println("Priority: " + tasks.get(i).getPriority());
            System.out.println("Date and time of creation: " + tasks.get(i).getDateAndTimeOfCreation());
            System.out.println("Date and time of deadline: " + tasks.get(i).getDateAndTimeOfDeadLine());
            System.out.println("Assigned users: ");
            for (int j = 0; j < tasks.get(i).getAssignedUsersSize(); j++) {
                System.out.println(tasks.get(i).getAssignedUsers(j));
            }
            System.out.println("Comments: ");
            for (int i1 = 0; i1 < tasks.get(i).getCommentSize(); i1++) {
                System.out.println("<" + tasks.get(i).getComments(i1).getUserName() + ">" + " " + ":" + " " + "<" + tasks.get(i).getComments(i1) + ">");
            }
        }
    }

    public void editTitle(Request request) {
        if (tasksPage) {
            if (users.get(loggedInUserIndex).getRole().equals("team leader")) {
                String taskId = request.getCommand().split("(\\[)")[1].split("(\\])")[0];
                String newTitle = request.getCommand().split("(\\[)")[2].split("(\\])")[0];
                for (Task task : tasks) {
                    if (taskId.equals(task.getId())) {
                        task.setTitle(newTitle);
                        System.out.println("Title updated successfully!");
                    }
                }
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void editDescription(Request request) {
        if (tasksPage) {
            if (users.get(loggedInUserIndex).getRole().equals("team leader")) {
                String taskId = request.getCommand().split("(\\[)")[1].split("(\\])")[0];
                String newDescription = request.getCommand().split("(\\[)")[2].split("(\\])")[0];
                for (Task task : tasks) {
                    if (taskId.equals(task.getId())) {
                        task.setDescription(newDescription);
                        System.out.println("Description updated successfully!");
                    }
                }
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void editPriority(Request request) {
        if (tasksPage) {
            if (users.get(loggedInUserIndex).getRole().equals("team leader")) {
                String taskId = request.getCommand().split("(\\[)")[1].split("(\\])")[0];
                String newPriority = request.getCommand().split("(\\[)")[2].split("(\\])")[0];
                for (Task task : tasks) {
                    if (taskId.equals(task.getId())) {
                        task.setPriority(newPriority);
                        System.out.println("Priority updated successfully!");
                    }
                }
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void editDeadLine(Request request) {
        if (tasksPage){
            if (users.get(loggedInUserIndex).getRole().equals("team leader")){
                int i;
                boolean regexMatch = false;
                boolean dateFormat = false;
                boolean taskIdExist = false;
                String taskId = request.getCommand().split("<")[1].split(">")[0];
                String newDeadLine = request.getCommand().split("<")[2].split(">")[0];
                for (i = 0 ; i < tasks.size() ; i++){
                    if (taskId.equals(tasks.get(i).getId())){
                        taskIdExist = true;
                        break;
                    }
                }
                if (newDeadLine.matches("\\d{4}(-)\\d{2}(-)\\d{2}(\\|)\\d{2}(:)\\d{2}")){
                    regexMatch = true;
                }
                if (taskIdExist){
                    if (regexMatch){
                        int yearOfDeadLine = Integer.parseInt(newDeadLine.split("-")[0]);
                        int monthOfDeadLine = Integer.parseInt(newDeadLine.split("-")[1]);
                        int dayOfDeadLine = Integer.parseInt(newDeadLine.split("-")[2].split("\\|")[0]);
                        int hourOfDeadLine = Integer.parseInt(newDeadLine.split("\\|")[1].split(":")[0]);
                        int minuteOfDeadLine = Integer.parseInt(newDeadLine.split("\\|")[1].split(":")[1]);
                        int yearOfCreation = Integer.parseInt(tasks.get(i).getDateAndTimeOfCreation().split("-")[0]);
                        int monthOfCreation = Integer.parseInt(tasks.get(i).getDateAndTimeOfCreation().split("-")[1]);
                        int dayOfCreation = Integer.parseInt(tasks.get(i).getDateAndTimeOfCreation().split("-")[2].split("\\|")[0]);
                        int hourOfCreation = Integer.parseInt(tasks.get(i).getDateAndTimeOfCreation().split("\\|")[1].split(":")[0]);
                        int minuteOfCreation = Integer.parseInt(tasks.get(i).getDateAndTimeOfCreation().split("\\|")[1].split(":")[1]);
                        if (yearOfDeadLine >= 1900 && yearOfDeadLine <= 2099 && monthOfDeadLine <= 12 && monthOfDeadLine >= 1 && dayOfDeadLine <= 31 && dayOfDeadLine >= 1 && hourOfDeadLine <= 23 && hourOfDeadLine >= 0 && minuteOfDeadLine <= 59 && minuteOfDeadLine >= 0 ){
                            if (newDeadLine.compareTo(tasks.get(i).getDateAndTimeOfCreation()) > 0){
                                dateFormat = true;
                            }
                        }
                    }
                    if (dateFormat){
                        System.out.println("Deadline updated successfully!");
                        tasks.get(i).setDateAndTimeOfDeadLine(newDeadLine);
                    } else
                        System.out.println("New deadline is invalid!");
                } else
                    System.out.println("there is no tasks with this id exists!");
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void addAssignedUser(Request request) {
        if (tasksPage) {
            if (users.get(loggedInUserIndex).getRole().equals("team leader")) {
                int userIndex = 0;
                boolean isUserExist = false;
                String taskId = request.getCommand().split("<")[1].split(">")[0];
                String userName = request.getCommand().split("<")[2].split(">")[0];
                for (int j = 0; j < users.size(); j++) {
                    if (userName.equals(users.get(j).getUserName())) {
                        isUserExist = true;
                        userIndex = j;
                    }
                }
                for (int i3 = 0; i3 < tasks.size(); i3++) {
                    if (tasks.get(i3).getId().equals(taskId)) {
                        if (isUserExist) {
                            tasks.get(i3).addAssignedUsers(userName);
                            System.out.println("User <" + userName + "> added successfully!");
                            users.get(userIndex).sendNotification("this task was assigned to you!");
                        }
                    }
                }
                if (!isUserExist) {
                    System.out.println("There is not any user with this username <" + userName + ">!");
                }
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void removeAssignedUser(Request request) {
        if (tasksPage) {
            if (users.get(loggedInUserIndex).getRole().equals("team leader")) {
                boolean isExist = false;
                boolean taskExist = false;
                String taskId = request.getCommand().split("<")[1].split(">")[0];
                String userName = request.getCommand().split("<")[2].split(">")[0];
                for (int i3 = 0; i3 < tasks.size(); i3++) {
                    if (tasks.get(i3).getId().equals(taskId)) {
                        taskExist = true;
                        for (int j = 0; j < tasks.get(i3).getAssignedUsersSize(); j++) {
                            if (userName.equals(tasks.get(i3).getAssignedUsers(j))) {
                                tasks.get(i3).removeAssignedUsers(j);
                                isExist = true;
                            }
                        }
                    }
                }
                if (isExist) {
                    System.out.println("User <" + userName + "> removed successfully!");
                } else if (taskExist && !isExist) {
                    System.out.println("There is not any user with this username <" + userName + "> in list!");
                }
            } else
                System.out.println("You Don't Have Access To Do This Action!");
        } else
            System.out.println("invalid command!");
    }

    public void teamMenu() {
        for (int i = 1; i <= users.get(loggedInUserIndex).getUsersTeamsCount(); i++) {
            System.out.println(i + " <" + users.get(loggedInUserIndex).getUsersTeamsName(i - 1) + ">");
        }
    }

    public void enterTeam(Request request) {
        int i;
        String teamName = request.getCommand().split("<")[1].split(">")[0];
        for (i = 0; i < teams.size(); i++) {
            if (teamName.equals(teams.get(i).getTeamName())) {
                break;
            }
        }
        myTeamNumber = i;
        teamMenu = true;
    }

    public void scoreBoardShow(Request request) {
        ArrayList<UserKamyar> usersOfTeams = new ArrayList<>() ;
//                Arrays.stream(users.toArray())
//                .filter((UserKamyar) user  -> {
//                    user.getUsersTeamsCount();
////
////                    for(ArrayList<String> userTeams : user.getUsersTeams()) {
////                        if() return true;
////                    }
////                    return false;
//                })


        for(UserKamyar userKamyar : users){
            for(String userTeams : userKamyar.getUsersTeams()){
                if (userTeams.equals(teams.get(myTeamNumber))){
                    usersOfTeams.add(userKamyar);
                    break;
                }
            }
        }
        if (teamMenu) {
            Comparator<UserKamyar> comparator = Comparator.comparing(userKamyar -> userKamyar.getScore());
            comparator = comparator.thenComparing(Comparator.comparing(userKamyar -> userKamyar.getUserName()));
            Stream<UserKamyar> userStream = usersOfTeams.stream().sorted(comparator);
            List<UserKamyar> sortedUserOfTeam = userStream.collect(Collectors.toList());
            for(int i = 0 ; i < sortedUserOfTeam.size() ; i++){
                System.out.println(i + sortedUserOfTeam.get(i).getUserName() + sortedUserOfTeam.get(i).getScore());
            }
//            .thenComparing(Comparator.comparing(userKamyar -> userKamyar.))
        } else
            System.out.println("invalid command!");
    }

    public void roadMapShow(Request request) {
        if (teamMenu) {
            if (teams.get(myTeamNumber).getTeamTasksCount() == 0) {
                System.out.println("no task yet");
            } else {
                for (int j = 0; j < teams.get(myTeamNumber).getTeamTasksCount(); j++) {
                    System.out.println("<" + teams.get(myTeamNumber).getTeamTasks(j).getTitle() + "> : <" + teams.get(myTeamNumber).getTeamTasks(j).getDonePercentage() + "> % done");
                }
            }
        } else
            System.out.println("invalid command!");
    }

    public void chatRoomShow(Request request) {
        if (teamMenu) {
            if (messages.size() == 0){
                System.out.println("no message yet");
            } else {
                for (int i = messages.size() - 1 ; i >= 0 ; i--){
                    System.out.println("<" + messages.get(i).getUserName() + "> : " + "\\\"" + "<" + messages.get(i).getText() + ">" + "\\\"");
                }
            }
        } else
            System.out.println("invalid command!");
    }

    public void sendMessage(Request request) {
        if (teamMenu) {
            String message = request.getCommand().split("<")[1].split(">")[0];
            messages.add(new Message(message, users.get(loggedInUserIndex).getUserName()));
        } else
            System.out.println("invalid command!");
    }
}
