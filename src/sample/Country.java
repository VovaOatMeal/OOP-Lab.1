package sample;

import javafx.beans.property.*;

public class Country {
    private IntegerProperty CountryID;
    private StringProperty Name;
    private StringProperty Capital;
    private StringProperty Region;
    private StringProperty Continent;
    private StringProperty Code;

    public Country(int id, String name, String capital, String region, String continent, String code) {
        CountryID = new SimpleIntegerProperty(id);
        Name = new SimpleStringProperty(name);
        Capital = new SimpleStringProperty(capital);
        Region = new SimpleStringProperty(region);
        Continent = new SimpleStringProperty(continent);
        Code = new SimpleStringProperty(code);
    }

    public int getCountryID() {
        return CountryID.get();
    }

    public IntegerProperty countryIDProperty() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        this.CountryID.set(countryID);
    }

    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getCapital() {
        return Capital.get();
    }

    public StringProperty capitalProperty() {
        return Capital;
    }

    public void setCapital(String capital) {
        this.Capital.set(capital);
    }

    public String getRegion() {
        return Region.get();
    }

    public StringProperty regionProperty() {
        return Region;
    }

    public void setRegion(String region) {
        this.Region.set(region);
    }

    public String getContinent() {
        return Continent.get();
    }

    public StringProperty continentProperty() {
        return Continent;
    }

    public void setContinent(String continent) {
        this.Continent.set(continent);
    }

    public String getCode() {
        return Code.get();
    }

    public StringProperty codeProperty() {
        return Code;
    }

    public void setCode(String code) {
        this.Code.set(code);
    }
}
