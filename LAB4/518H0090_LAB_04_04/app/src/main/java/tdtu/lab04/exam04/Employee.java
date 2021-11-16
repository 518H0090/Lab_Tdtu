package tdtu.lab04.exam04;

public class Employee {
    private String EName;
    private String EDepartment;
    private int EImage;

    public Employee(String EName, String EDepartment, int EImage) {
        this.EName = EName;
        this.EDepartment = EDepartment;
        this.EImage = EImage;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getEDepartment() {
        return EDepartment;
    }

    public void setEDepartment(String EDepartment) {
        this.EDepartment = EDepartment;
    }

    public int getEImage() {
        return EImage;
    }

    public void setEImage(int EImage) {
        this.EImage = EImage;
    }
}
