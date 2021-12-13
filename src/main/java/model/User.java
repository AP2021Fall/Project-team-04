package model;


import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    public static ArrayList<User> allUsers = new ArrayList<User>();
    protected ArrayList<Team> allJoinedTeams = new ArrayList<Team>();
    protected ArrayList<Task> tasks = new ArrayList<>();
    protected ArrayList<Notification> userNotifications = new ArrayList<>();
    protected String completeName;
    protected String userName;
    protected String stringOfBirthDay;
    protected LocalDate birthday;
    protected String email;
    protected String role;
    protected int score;

    public User(String completeName , String userName , String stringOfBirthDay , String email , String role , int score){
        this.completeName = completeName;
        this.userName = userName;
        this.stringOfBirthDay = stringOfBirthDay;
        this.birthday = LocalDate.of(Integer.parseInt(stringOfBirthDay.split("-")[0]) , Integer.parseInt(stringOfBirthDay.split("-")[1])  , Integer.parseInt(stringOfBirthDay.split("-")[2]) );
        this.email = email;
        this.role = role;
        this.score = score;
        allUsers.add(this);
    }

    public ArrayList<Team> getAllJoinedTeams() {
        return allJoinedTeams;
    }

    public void joinTeam(Team team){
        allJoinedTeams.add(team);
    }

    public void addNotification(Notification notification){
        userNotifications.add(notification);
    }

    public void runMainMenu(User user){

    }
}
