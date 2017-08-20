package modelFx;

import database.dao.ProducentDao;
import database.dbutils.DbManager;
import database.models.Producent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import utils.converters.ConverterProducent;
import utils.exceptions.ApplicationException;

public class ProducentModel {

    private ObjectProperty<ProducentFx> producentFxObjectProperty = new SimpleObjectProperty<>(new ProducentFx());


    public void saveProducentInDatabase() throws ApplicationException {
        ProducentDao producentDao = new ProducentDao();
        Producent producent = ConverterProducent.convertProducentFxToProducent(this.getProducentFxObjectProperty());
        producentDao.createOrUpdate(producent);
        DbManager.closeConnectionSource();
    }

    public ProducentFx getProducentFxObjectProperty() {
        return producentFxObjectProperty.get();
    }

    public ObjectProperty<ProducentFx> producentFxObjectPropertyProperty() {
        return producentFxObjectProperty;
    }

    public void setProducentFxObjectProperty(ProducentFx producentFxObjectProperty) {
        this.producentFxObjectProperty.set(producentFxObjectProperty);
    }
}
