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
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}