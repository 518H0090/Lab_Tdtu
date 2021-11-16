package tdtu.lab02.exam04;

public class Language {
    private long id;
    private String name;
    private float percent;

    public Language(long id, String name, float percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
