package sample.interfaces;

import sample.model.bean.Usuario;

import java.util.List;

public interface UserDAOInterface {

    //Create a new User on system
    public abstract boolean create(Usuario user);

    //Delete a specific user
    public abstract boolean delete(Usuario user);

    //List all the users of the system
    public abstract List<Usuario> listUsers();

    //Select user by login
    public abstract Usuario select(String login);

    //Select user by login
    public abstract List<Usuario> find(String field, String login);

    //select a user by his ID
    public abstract Usuario selectById(int id);

    //method to update a user
    public abstract boolean updateUser(Usuario usuario);

    //method to update a user password
    public  abstract boolean updatePassword(Usuario usuario);

}
