package tdtu.lab06.exam03;

public class Phone {
    String phoneName;
    boolean checkSelect;

    public Phone(String phoneName, boolean checkSelect) {
        this.phoneName = phoneName;
        this.checkSelect = checkSelect;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public boolean isCheckSelect() {
        return checkSelect;
    }

    public void setCheckSelect(boolean checkSelect) {
        this.checkSelect = checkSelect;
    }
}
