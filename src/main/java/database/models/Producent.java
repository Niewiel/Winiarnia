package database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by niewiel on 23.05.17.
 */
@DatabaseTable(tableName ="Producent")
public class Producent implements BaseModel {
    public Producent() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "IMIĘ",canBeNull = false)
    private String imię;

    @DatabaseField(columnName = "NAZWISKO",canBeNull = false)
    private String nazwisko;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Wino> wina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ForeignCollection<Wino> getWina() {
        return wina;
    }

    public void setWina(ForeignCollection<Wino> wina) {
        this.wina = wina;
    }
}
