package model;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private String teamLeaderName;
    private ArrayList<String> teamMembers = new ArrayList<>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName;
    }

   public int getTeamMembersCount(){
        return teamMembers.size();
   }

   public String getTeamMemberName(int i){
        return teamMembers.get(i);
   }
}
