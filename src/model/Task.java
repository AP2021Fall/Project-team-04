package model;

<<<<<<< HEAD:src/model/Task.java
import java.util.ArrayList;

public class Task {
    ArrayList<String> assignedUsers = new ArrayList<>();
    ArrayList<Comment> comments = new ArrayList<>();
    private String id;
    private String title;
    private String description;
    private String priority;
    private String dateAndTimeOfCreation;
    private String dateAndTimeOfDeadLine;
    private String donePercentage;

    public int getAssignedUsersSize(){
        return assignedUsers.size();
    }

    public String getAssignedUsers(int i){
        return assignedUsers.get(i);
    }

    public void addAssignedUsers(String userName){
        assignedUsers.add(userName);
    }

    public void removeAssignedUsers(int i){
        assignedUsers.remove(i);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDateAndTimeOfCreation() {
        return dateAndTimeOfCreation;
    }

    public void setDateAndTimeOfCreation(String dateAndTimeOfCreation) {
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
    }

    public String getDateAndTimeOfDeadLine() {
        return dateAndTimeOfDeadLine;
    }

    public void setDateAndTimeOfDeadLine(String dateAndTimeOfDeadLine) {
        this.dateAndTimeOfDeadLine = dateAndTimeOfDeadLine;
    }

    public int getCommentSize() {
        return comments.size();
    }

    public Comment getComments(int i){
        return comments.get(i);
    }

    public void setComments(Comment comment) {
        comments.add(comment);
    }

    public String getDonePercentage() {
        return donePercentage;
    }

    public void setDonePercentage(String donePercentage) {
        this.donePercentage = donePercentage;
    }
=======
public class Task {
>>>>>>> 266df34637a7e49546de53088fa4b2c229486789:src/main/java/model/Task.java
}
