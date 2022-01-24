package view;

import controller.Utilities;
import model.RequestType;
import model.Team;
import model.User;
import org.postgresql.jdbc.EscapedFunctions2;

public class MainMenu {
    private User user;
    private boolean profileMenu;
    private boolean teamMenu = false;
    private boolean tasksPage = false;
    private boolean calendarMenu = false;
    private boolean notificationBar = false;

    public MainMenu(User user) {
        this.user = user;
    }

    public void enterMenu(String command) {
        String menuName = command.split("<")[1];
        switch (menuName) {
            case "Profile Menu":
                this.profileMenu = true;
            case "Team Menu":
                this.teamMenu = true;
            case "Tasks Page":
                this.tasksPage = true;
            case "Calendar Menu":
                this.calendarMenu = true;
            case "Notification Bar":
                this.notificationBar = true;
            default:
                System.out.println("invalid command!");
        }
    }

    public Object goToAMenu() {
        if (this.profileMenu) {
            ProfileMenu profileMenu = new ProfileMenu(this.user);
            this.profileMenu = false;
            return profileMenu;
        } else if (this.calendarMenu) {
            CalenderMenu calenderMenu = new CalenderMenu(this.user);
            this.calendarMenu = false;
            return calenderMenu;
        } else if (this.teamMenu) {
            TeamMenu teamMenu = new TeamMenu(this.user);
            this.teamMenu = false;
            return teamMenu;
        } else if (this.notificationBar) {
            NotificationBar notificationBar = new NotificationBar(this.user);
            this.notificationBar = false;
            return notificationBar;
        } else if (this.tasksPage) {
            TasksPage tasksPage = new TasksPage(this.user);
            this.tasksPage = false;
            return tasksPage;
        } else {
            System.out.println("Sth to DO");
            this.profileMenu = false;
            this.teamMenu = false;
            this.tasksPage = false;
            this.calendarMenu = false;
            this.notificationBar = false;
            return null;
        }
    }
}
