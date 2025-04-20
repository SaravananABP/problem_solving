package SuperStore.Profile;

import SuperStore.InputOutput;

import java.util.HashMap;

public class ProfileService {
    public static HashMap<Integer, ProfileDetails> userInfo = new HashMap<>();
//    userInfo.put(0);
    public static void createNewUser() {
        String name = InputOutput.strInput("Name");
        String password = InputOutput.strInput("Password");
        String role = InputOutput.strInput("Role");
        ProfileDetails profileDetails = new ProfileDetails(name, password, role);
        userInfo.put(userInfo.size(), profileDetails);
        InputOutput.status("Success user created !!!");
    }

    public static ProfileDetails getUserData(String name, String password) {
        password = ProfileDetails.encrypt(password);
        for (int i = 0; i < userInfo.size(); i++) {
            ProfileDetails profileDetails = userInfo.get(i);
            if (profileDetails.getName().equals( name) && password.equals(profileDetails.getPassword())) {
                return profileDetails;
            }
        }
        return null;
    }

    public static boolean validateUser(String name, String password) {
        password = ProfileDetails.encrypt(password);
        for (int i = 0; i < userInfo.size(); i++) {
//            System.out.println(password == profileDetails.getPassword()+"pass");
            ProfileDetails profileDetails = userInfo.get(i);
            if (profileDetails.getName().equals(name) && profileDetails.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static void getAllUser() {
        for (int i = 0; i < userInfo.size(); i++) {
            System.out.println(userInfo.get(i).toString());
        }
    }
    public static void getAllProfileDetails(){
        InputOutput.title("welcome to profile page");
        boolean flag=true;
        while (flag){
            InputOutput.option("Sign up..get all profile..exit");
            int choice=InputOutput.intInput("choice");
            switch (choice){
                case 1:
                    createNewUser();
                    break;
                case 2:
                    getAllUser();
                    break;
                case 3:
                    flag=false;
                default:
                    InputOutput.status("Invalid choice chosen");
            }
            InputOutput.endLine();
        }
    }
}
