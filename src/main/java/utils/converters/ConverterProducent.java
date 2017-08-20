package utils.converters;

import database.models.Producent;
import modelFx.ProducentFx;

public class ConverterProducent {

    public static Producent convertProducentFxToProducent(ProducentFx producentFx){
        Producent producent=new Producent();
        producent.setImię(producentFx.getName());
        producent.setNazwisko(producentFx.getSurname());
        return producent;
    }
}
