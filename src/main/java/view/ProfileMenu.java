package view;
import model.*;

import java.time.LocalDate;

public class ProfileMenu {
    private User user;

    public ProfileMenu(User user){
        this.user = user;
    }

    public void changePassWord(){

    }

    public void changeUserName(){

    }
    public void showTeams(){

    }

    public void showTeam(String teamName){

    }

    public void showProfile(){

    }

    public void showLogs(){

    }

    public void showNotification(){

    }

    public void changePassWord(String command){
            int wrongPassWordCount = 0;
            boolean isPassWordSameWithOneOfOlds = false;
            while (wrongPassWordCount < 2){
                String oldPassWord = command.split("<")[1];
                String newPassWord = command.split("<")[2];
                if (!oldPassWord.equals(user.getPassword())){
                    System.out.println("wrong old password!");
                    if (wrongPassWordCount == 0) {
                        wrongPassWordCount++;
                    } else if (wrongPassWordCount == 1){
                        System.out.println("wrong old password!");
                        user.setLogin(false);
                        wrongPassWordCount = 0;
                    }
                } else {
//                    for (int i1 = 0 ; i1 < users.get(loggedInUserIndex).getUserAllPassWordsSize() ; i1++){
//                        if (newPassWord.equals(users.get(loggedInUserIndex).getUserAllPassWords(i1))){
//                            isPassWordSameWithOneOfOlds = true;
//                            break;
//                        }
//                    }
                    if (user.getPassword().equals(newPassWord)){
                        isPassWordSameWithOneOfOlds = true;
                    }
                    if (isPassWordSameWithOneOfOlds){
                        System.out.println("Please type a New Password !");
                    } else if ((!newPassWord.matches("[A-Z0-9]+\\S+")) || newPassWord.length() < 8){
                        System.out.println("Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)");
                    } else {
                        user.setPassword(newPassWord);
                        System.out.println("new password set successfully");
                    }
                }
            }
    }




}
