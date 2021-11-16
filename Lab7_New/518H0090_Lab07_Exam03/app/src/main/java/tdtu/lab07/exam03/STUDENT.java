package tdtu.lab07.exam03;

public class STUDENT {
    private int ID;
    private String STUDENTNAME;
    private String CLASS;

    public STUDENT() {
    }

    public STUDENT(String STUDENTNAME, String CLASS) {
        this.STUDENTNAME = STUDENTNAME;
        this.CLASS = CLASS;
    }

    public STUDENT(int ID, String STUDENTNAME, String CLASS) {
        this.ID = ID;
        this.STUDENTNAME = STUDENTNAME;
        this.CLASS = CLASS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSTUDENTNAME() {
        return STUDENTNAME;
    }

    public void setSTUDENTNAME(String STUDENTNAME) {
        this.STUDENTNAME = STUDENTNAME;
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }
}
