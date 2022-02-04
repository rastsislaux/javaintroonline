package engineer.leepsky.javaintroonline.tasks.notebook;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note implements Serializable {

    private final String theme, email, text;
    private final Calendar dateOfCreation;

    Note(String theme, String email, String text) {
        this.theme = theme;
        if (validate(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email address is invalid.");
        }
        this.text = text;
        dateOfCreation = new GregorianCalendar();
    }

    public String getTheme() {
        return theme;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    public Calendar getDateOfCreation() {
        return (Calendar)dateOfCreation.clone();
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public String toString() {
        return "Note{" +
                "theme='" + theme + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(theme, note.theme) && Objects.equals(email, note.email) && Objects.equals(text, note.text) && Objects.equals(dateOfCreation, note.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theme, email, text, dateOfCreation);
    }

}
