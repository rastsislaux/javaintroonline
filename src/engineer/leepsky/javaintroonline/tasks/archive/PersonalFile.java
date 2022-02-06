package engineer.leepsky.javaintroonline.tasks.archive;

import java.io.Serializable;
import java.net.ServerSocket;
import java.util.Objects;

public class PersonalFile implements Serializable {

    private String name;
    private String info;

    PersonalFile(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "PersonalFile{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalFile that = (PersonalFile) o;
        return Objects.equals(name, that.name) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

}
