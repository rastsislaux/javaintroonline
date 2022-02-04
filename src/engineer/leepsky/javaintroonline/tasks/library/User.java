package engineer.leepsky.javaintroonline.tasks.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {

    private final String login;
    private String passwordHash;
    private boolean isAdministrator;
    private ArrayList<String> messages = new ArrayList<>();

    User(String login, String passwordHash, boolean isAdministrator) {

        this.login = login;
        this.passwordHash = passwordHash;
        this.isAdministrator = isAdministrator;

    }

    public String getLogin() {
        return login;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public void setPassword(String password) {
        this.passwordHash = Utils.sha256(password);
    }

    public boolean isCorrectPassword(String password) {
        return Utils.sha256(password).equals(passwordHash);
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return new ArrayList<String>(messages);
    }

    public static void sendMessage(String path, String to, String msg) {

        try {
            Files.writeString(
                    Paths.get(path),
                    to + "\n[" + new Date() + "] " + msg + "\n",
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", isAdministrator=" + isAdministrator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdministrator == user.isAdministrator && Objects.equals(login, user.login) && Objects.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, passwordHash, isAdministrator);
    }

}
