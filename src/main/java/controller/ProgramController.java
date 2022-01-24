package controller;

import model.Notification;
import model.RequestType;
import model.Team;
import model.User;
import view.*;

import java.util.Scanner;

public class ProgramController {
    public void run() {
        printWelcome();
        String welcomeMenuCommand = Utilities.scanner.nextLine().strip();
        if (welcomeMenuCommand.equals("1")){
            String userCreateCommand = Utilities.scanner.nextLine();
            if (Request.getType(userCreateCommand) == RequestType.USER_CREATE){
                userCreate(userCreateCommand);
            }else {
                System.out.println("invalid command");
            }
        }else if (welcomeMenuCommand.equals("2")){
            String loginCommand = Utilities.scanner.nextLine();
            if (Request.getType(loginCommand) == RequestType.USER_LOGIN){
                userLogin(loginCommand);
            }else {
                System.out.println("invalid command");
            }
        }else {
            System.out.println("invalid command");
        }
    }
    public  void userCreate(String command) {
        boolean isUserNameExist = false;
        boolean isEmailExist = false;
        String userName = command.split("<")[1];
        String password1 = command.split("<")[2];
        String password2 = command.split("<")[3];
        String email = command.split("<")[4];
        String birthday = command.split("<")[5];
        for (int i = 0; i < User.allUsers.size(); i++) {
            if (userName.equals(User.allUsers.get(i).getUserName())) {
                isUserNameExist = true;
                break;
            }
        }
        for (int j = 0; j < User.allUsers.size(); j++) {
            if (email.equals(User.allUsers.get(j).getEmail())) {
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
            if (Utilities.getCommandMatcher(birthday , "^\\d{4}-\\d{2}-\\d{2}$").matches()){
                System.out.println("user created successfully!");
                User user = new User(userName , "" , email , password1);
            }
        }
    }

        public void userLogin(String command) {
            int i;
            boolean isUserExists = false;
            String userName = command.split("<")[1];
            String passWord = command.split("<")[2];
        if (!User.getUserByUserName(userName).isLogin()) {
            for (i = 0; i < User.allUsers.size(); i++) {
                if (userName.equals(User.allUsers.get(i).getUserName())) {
                    isUserExists = true;
                    break;
                }
            }
            if (!isUserExists) {
                System.out.println("There is not any user with username:" + " " + "<" + userName + ">" + "!");
            } else if (!passWord.equals(User.allUsers.get(i).getPassword())) {
                System.out.println("Username and password didn't match!");
            } else {
                System.out.println("user logged in successfully!");
                MainMenu mainManu = new MainMenu(User.getUserByUserName(userName));
                runMainMenu(mainManu);
            }
        } else
            System.out.println("you are already login!");
    }

    public void printWelcome() {
        System.out.println("welcome to jira v.1  please choose one of this tasks to continue:");
        System.out.println("Please Choose 1 for SignUp Or If You Already Have an Account Choose 2 For Login:");
    }

    public void registerUser(String username, String password1, String password2, String email, String birthday) {
        boolean isUserNameExists = false;
        for (User user : User.allUsers) {
            if (user.getUserName().equals(username)) {
                System.out.println("user with username " + username + "already exists!");
                isUserNameExists = true;
                break;
            }
        }
        if (!isUserNameExists) {
            if (!password1.equals(password2)) {
                System.out.println("Your passwords are not the same!");
            } else {
                boolean isEmailExists = false;
                for (User user : User.allUsers) {
                    if (user.getEmail().equals(email)) {
                        System.out.println("user with this email already exists!");
                        isEmailExists = true;
                        break;
                    }
                }
                if (!isEmailExists) {
                    if (Utilities.getCommandMatcher(email, "^[\\w.]+@(gmail.com|yahoo.com)$").matches()) {
                        User user = new User(username, birthday, email, password1);
                        System.out.println("user crated successfully!");
                    }
                }
            }
        }
    }

    public void runMainMenu(MainMenu mainMenu){
        System.out.println("1: Profile Menu");
        System.out.println("2: Team Menu --> { Chat Room - Board Menu - ScoreBoard - RoadMaps }");
        System.out.println("3: Tasks Page");
        System.out.println("4: Calendar Menu");
        System.out.println("5: Notification Bar");
        String goToAMenuCommand = Utilities.scanner.nextLine().strip();
        if (Request.getType(goToAMenuCommand) == RequestType.ENTER_MENU) {
            mainMenu.enterMenu(goToAMenuCommand);
            Object nextMenu = mainMenu.goToAMenu();
            if (nextMenu != null){
                if (nextMenu instanceof ProfileMenu){
                    ProfileMenu profileMenu = (ProfileMenu) nextMenu;
                    runProfileMenu(profileMenu);
                }else if (nextMenu instanceof TeamMenu){
                    TeamMenu teamMenu = (TeamMenu) nextMenu;
                    runTeamMenu(teamMenu);
                }else if (nextMenu instanceof TasksPage){
                    TasksPage tasksPage = (TasksPage) nextMenu;
                    runTasksPage(tasksPage);
                }else if (nextMenu instanceof CalenderMenu){
                    CalenderMenu calenderMenu = (CalenderMenu) nextMenu;
                    runCalenderMenu(calenderMenu);
                }else if (nextMenu instanceof NotificationBar){
                    NotificationBar notificationBar = (NotificationBar) nextMenu;
                    runNotificationBar(notificationBar);
                }
            }
        } else {
            System.out.println("sth");
        }

    }
    public void runProfileMenu(ProfileMenu profileMenu){

    }
    public void runTeamMenu(TeamMenu teamMenu){

    }
    public void runTasksPage(TasksPage tasksPage){

    }
    public void runCalenderMenu(CalenderMenu calenderMenu){

    }
    public void runNotificationBar(NotificationBar notificationBar){

    }
}
