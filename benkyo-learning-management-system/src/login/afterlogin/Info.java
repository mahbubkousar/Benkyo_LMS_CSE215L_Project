package login.afterlogin;

public class Info {

    private int serial;
    private String name;
    private String faculty;
    private int section;
    private int credit;

    public Info(int serial, String name, String faculty, int section, int credit) {
        this.serial = serial;
        this.name = name;
        this.faculty = faculty;
        this.section = section;
        this.credit = credit;
    }

    public int getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getSection() {
        return section;
    }

    public int getCredit() {
        return credit;
    }

}
