package sample.model.bean;

public class Config {

    private String user;
    private String password;
    private String server;
    private String port;

    public Config() {

        this.user = null;
        this.password = null;
        this.server = null;
        this.port = null;

    }

    public Config(String user, String password, String server, String port) {

        this.user = user;
        this.password = password;
        this.server = server;
        this.port = port;

    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getServer() {
        return this.server;
    }

    public String getPort() {
        return this.port;
    }

}