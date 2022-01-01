package model;

import java.util.ArrayList;

public class User {
    private String fullName;
    private String userName;
    private String passWord;
    private String birthDayDate;
    private String email;
    private String role;
    private int score;
    private ArrayList<String> userAllPassWords = new ArrayList<>();
    private ArrayList<String> usersTeams = new ArrayList<>();
    private ArrayList<String> notifications = new ArrayList<>();

    public User(String userName, String passWord, String email , String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(String birthDayDate) {
        this.birthDayDate = birthDayDate;
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

    public ArrayList<String> getUserAllPassWords() {
        return userAllPassWords;
    }

    public void setUserAllPassWords(ArrayList<String> userAllPassWords) {
        this.userAllPassWords = userAllPassWords;
    }

    public void addUserAllPassWords(String passWord){
        userAllPassWords.add(passWord);
    }

    public int getUserAllPassWordsSize(){
        return userAllPassWords.size();
    }

    public String getUserAllPassWords(int i){
        return userAllPassWords.get(i);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUsersTeamsCount(){
        return usersTeams.size();
    }

    public String getUsersTeamsName(int i){
        return usersTeams.get(i);
    }

    public int getNotificationsCount(){
        return notifications.size();
    }

    public String getNotifications(int i){
        return notifications.get(i);
    }
}
