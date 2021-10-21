package tdtu.lab04.exam05;

public class Country {
    private String countryName;
    private String flagName;
    private String populationCountry;

    public Country(String countryName, String flagName, String populationCountry) {
        this.countryName = countryName;
        this.flagName = flagName;
        this.populationCountry = populationCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
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
                "countryName='" + countryName + '\'' +
                ", flagName='" + flagName + '\'' +
                ", populationCountry='" + populationCountry + '\'' +
                '}';
    }
}
