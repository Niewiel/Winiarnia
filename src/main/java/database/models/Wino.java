package database.models;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by niewiel on 23.05.17.
 */
public class Wino implements BaseModel {

    public static final String Wytwórca_ID = "WYTWÓRCA_ID";
    public static final String Category_ID = "KATEGORY0_ID";

    public Wino() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = Wytwórca_ID, foreign = true, foreignAutoRefresh = true,
            foreignAutoCreate = true, canBeNull = false)
    private Producent producent;

    @DatabaseField(columnName = Category_ID, foreign = true, foreignAutoRefresh = true,
            foreignAutoCreate = true, canBeNull = false)
    private Category category;

    @DatabaseField(columnName = "NAZWA",canBeNull = false)
    private String nazwa;

    @DatabaseField(columnName = "OPIS")
    private String opis;

    @DatabaseField(columnName = "rocznik")
    private int rocznik;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }
}
