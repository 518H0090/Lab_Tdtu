package tdtu.lab04.exam04;

public class Country {
    private int ImgCountry;
    private String nameCountry;
    private String populationCountry;

    public Country() {
    }

    public Country(int imgCountry, String nameCountry, String populationCountry) {
        ImgCountry = imgCountry;
        this.nameCountry = nameCountry;
        this.populationCountry = populationCountry;
    }

    public int getImgCountry() {
        return ImgCountry;
    }

    public void setImgCountry(int imgCountry) {
        ImgCountry = imgCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getPopulationCountry() {
        return populationCountry;
    }

    public void setPopulationCountry(String populationCountry) {
        this.populationCountry = populationCountry;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nameCountry='" + nameCountry + '\'' +
                ", populationCountry='" + populationCountry + '\'' +
                '}';
    }
}
