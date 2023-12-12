package app.AdminLoginCredentials;

import java.util.Arrays;

import static app.Constants.db;

public class AdminLoginPage {
    String userID;
    String password;
    private int totalUsers=0;

    public AdminLoginPage(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public void createAdminUser(){
        if(totalUsers<=9) {
            for (int i=0;i<=totalUsers;i++) {
                if(!db.loginCredentials[i][0].equalsIgnoreCase(userID)){
                    db.loginCredentials[totalUsers][0] = userID;
                    db.loginCredentials[totalUsers][1] = password;
                }
            }
            totalUsers++;
        }
    }
    public boolean adminAuthenticate(){
        for(int i=0;i<=totalUsers;i++){
            if (db.loginCredentials[i][0].equalsIgnoreCase(userID)&&db.loginCredentials[i][1].equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }

}
