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
    protected String password;
    protected boolean isLogin = false;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStringOfBirthDay() {
        return stringOfBirthDay;
    }

    public void setStringOfBirthDay(String stringOfBirthDay) {
        this.stringOfBirthDay = stringOfBirthDay;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected String email;
    protected String role;
    protected int score;

    public User( String userName , String stringOfBirthDay , String email , String password){
//        this.completeName = completeName;
        this.userName = userName;
        this.stringOfBirthDay = stringOfBirthDay;
        this.birthday = LocalDate.of(Integer.parseInt(stringOfBirthDay.split("-")[0]) , Integer.parseInt(stringOfBirthDay.split("-")[1])  , Integer.parseInt(stringOfBirthDay.split("-")[2]) );
        this.email = email;
        this.role = role;
        this.password = password;
//        this.score = score;
        allUsers.add(this);
    }

    public ArrayList<Team> getAllJoinedTeams() {
        return allJoinedTeams;
    }

    public void addTask(Task task){tasks.add(task);}

    public void joinTeam(Team team){
        allJoinedTeams.add(team);
    }

    public void addNotification(Notification notification){
        userNotifications.add(notification);
    }

    public void runMainMenu(User user){

    }

    public static User getUserByUserName(String username){
        for (User user : allUsers) {
            if (user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }
}
