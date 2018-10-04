package sample.model.bean;

public class Session {
    private static int userId;
    private static String userLogin;
    private static String userName;
    private static String userCargo;

    public static void start(Usuario user) {
        userId = user.getId();
        userLogin = user.getLogin();
        userName = user.getNome();
        userCargo = user.getCargo();
    }

    public static void close() {
        userId = 0;
        userLogin = null;
        userName = null;
        userCargo = null;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserCargo() {
        return userCargo;
    }
}
