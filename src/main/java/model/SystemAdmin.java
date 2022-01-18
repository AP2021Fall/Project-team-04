package model;

import java.util.ArrayList;

public class SystemAdmin extends User{
    public static ArrayList<Team> requestedTeams = new ArrayList<>();
    public SystemAdmin(String completeName , String userName , String stringOfBirthDay , String email , String role , int score){
        super(completeName , userName , stringOfBirthDay ,  email , role , score);
    }

}
