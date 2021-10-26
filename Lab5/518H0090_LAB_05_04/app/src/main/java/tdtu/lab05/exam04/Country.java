package tdtu.lab05.exam04;

public class Country {

    private String countryImageName;
    private String countryName;
    private int countryPopulation;

    public Country(String countryImageName, String countryName, int countryPopulation) {
        this.countryImageName = countryImageName;
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }

    public String getCountryImageName() {
        return countryImageName;
    }

    public void setCountryImageName(String countryImageName) {
        this.countryImageName = countryImageName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryImageName='" + countryImageName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryPopulation=" + countryPopulation +
                '}';
    }
}
