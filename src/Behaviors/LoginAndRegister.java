package Behaviors;

import Entities.LoginUser.User;
import Entities.staffs.Manager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginAndRegister {
    private static final String PATH = "C:\\Users\\thait\\OneDrive\\Desktop\\Case_Module_2\\case_stady\\src\\UserLogin.dat";
    static List<User> users = (List<User>) ReadWrite.readFromFile(PATH);

    public static void login(String userName, String password) throws Exception {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    return;
                }
            }
        }
        throw new Exception("User is not exist!!!");
    }

    public static void register(User user) throws Exception {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new Exception("Username existed!!! Please try again");
            }
        }
        users.add(user);
        ReadWrite.writeObjectToFile(users, PATH);
    }

    public static void show() {
        for (User u : users) {
            System.out.println("" +
                    "Account: " +
                    "\nUsername: " + u.getUserName() +
                    "\nPassword: " + u.getPassword());
        }
    }

    public static void delete(String username) throws Exception {
        for (User u : users) {
            if (u.getUserName().equals(username)) {
                users.remove(u);
                System.out.println("User '" + username + "' has been deleted!!!");
                ReadWrite.writeObjectToFile(users, PATH);
                return;
            }
        }
        throw new Exception("User not exist!!!");
    }

    public static boolean checkPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
