package DLList;

import java.util.Objects;

enum DEPARTMENT{
    SE,//0
    IT,//1
    COM,//2
    AIDS,
    MRE,
    IMSE,
    RE
}
enum LEVELS{
    Level_One,
    Level_Two,
    Level_Three,
    Level_Four,
    Level_FIVE
}

public class Student {
    private String Name;
    private  long ID;
    private DEPARTMENT dep;
    private LEVELS level;
    private double avg;

    public Student() {ID=System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        level=LEVELS.Level_One;
        dep=DEPARTMENT.SE;
    }
    public Student(String name) {
        this();
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public long getID() {
        return ID;
    }
    public DEPARTMENT getDep() {
        return dep;
    }
    public void setDep(DEPARTMENT dep) {
        this.dep = dep;
    }
    public LEVELS getLevel() {
        return level;
    }
    public void setLevel(LEVELS level) {
        this.level = level;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", ID=" + ID +
                ", dep=" + dep +
                ", level=" + level +
                ", avg=" + avg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID && Double.compare(avg, student.avg) == 0 &&
                Objects.equals(Name, student.Name) &&
                dep == student.dep && level == student.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, ID, dep, level, avg);
    }
}