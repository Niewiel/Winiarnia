package database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "CATEGORIES")
public class Category implements BaseModel{
    public Category(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME",canBeNull = false,unique = true)
    private String name;

    @ForeignCollectionField(columnName = "WINO_ID")
    private ForeignCollection<Wino> wina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Wino> getWina() {
        return wina;
    }

    public void setWina(ForeignCollection<Wino> wina) {
        this.wina = wina;
    }
}