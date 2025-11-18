package DDList;

enum DEPMAIRMENT {
    SE,
    IT,
    AI
}

enum LEVELS {
    Level_One,
    Level_Tow,
    Level_Three,
    Level_Four

}

public class Student {
    private String Name;
    private Long ID;
    private LEVELS Level;
    private DEPMAIRMENT Dept;
    private double avg;

    Student() {
        ID = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        Level = LEVELS.Level_One;
        Dept = DEPMAIRMENT.SE;
    }
}
