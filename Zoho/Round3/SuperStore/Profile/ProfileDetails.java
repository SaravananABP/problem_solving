package SuperStore.Profile;

public class ProfileDetails {


    public Long userId = 2000L;
    private String name;
    private String password;
    private String role;
    public static Long nexLong=1L;

    public Long getUserId() {
        return userId;
    }

    public  void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ProfileDetails() {

    }

    @Override
    public String toString() {
        return "ProfileDetails{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public ProfileDetails(String name, String password, String role) {
        this.name = name;
        password = encrypt(password);
        this.password = password;
        this.role = role;
        nexLong++;
        this.userId = getUserId()+nexLong;
    }

    public static String encrypt(String pass) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pass.length(); i++) {
            result.append((char) (pass.charAt(i) + 9));
        }
        return result.toString();
    }

    public static String decrypt(String pass) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pass.length(); i++) {
            result.append((char) (pass.charAt(i) - 9));
        }
        return result.toString();
    }

}
