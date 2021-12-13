package controller;

import java.util.Scanner;

public class ProgramController {
    public static Scanner scanner = new Scanner(System.in);
    public void run(){
        printWelcome();
        String firstPageComment = scanner.nextLine();
        if (Utilities.getCommandMatcher(firstPageComment , "user create --username \\w{5,10} --password1 [a-zA-Z0-9]{8,12} --password2 [a-zA-Z0-9]{8,12} --email Address \\w{3,20}@(gmail|yahoo).com").matches()){
            String username = firstPageComment.split("\\s")[3];
            String password1 = firstPageComment.split("\\s")[5];
            String password2 = firstPageComment.split("\\s")[7];
            String email = firstPageComment.split("\\s")[10];

            registerUser(username , password1 , password2 , email);
        }else if (firstPageComment.equals("2")){

        }else {
            System.out.println("Invalid Command");
        }

    }
    public void printWelcome(){
        System.out.println("welcome to jira v.1  please choose one of this tasks to continue:");
//        System.out.println("Please Choose 1 for SignUp Or If You Already Have an Account Choose 2 For Login:");
    }

    public void registerUser(String username , String password1 , String password2 , String email){

    }
}
