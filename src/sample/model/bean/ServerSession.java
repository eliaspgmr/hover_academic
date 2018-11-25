package sample.model.bean;

import sample.config.RWConfig;

public class ServerSession {
    private static String user;
    private static String password;
    private static String server;
    private static String port;

    public static void update(){
        RWConfig.createFile();
        Config config = RWConfig.read();

        user     = config.getUser();
        password = config.getPassword();
        server   = config.getServer();
        port     = config.getPort();
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getServer() {
        return server;
    }

    public static String getPort() {
        return port;
    }
}
