package by.htp.example.validation;

public class UserDataValidator {

    private static final UserDataValidator instance = new UserDataValidator();

    public UserDataValidator() {
    }

    public boolean check(String login, String password) {
        return true;
    }

    public static UserDataValidator getInstance() {

        return instance;
    }
}
