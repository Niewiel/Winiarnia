package utils.exceptions;

import database.dao.CategoryDao;
import database.dao.WineDao;
import database.dbutils.DbManager;
import database.models.Category;
import database.models.Producent;
import database.models.Wino;

/**
 * Created by niewiel on 05.07.17.
 */
public class FillDatabase {
    public static void filldatabase(){
        Category category1 = new Category();
        category1.setName("Wytrawne");
        Producent producent1 = new Producent();
        producent1.setImię("Jozin");
        producent1.setNazwisko("Zbazin");
        Wino wino1= new Wino();
        wino1.setCategory(category1);
        wino1.setProducent(producent1);
        wino1.setNazwa("Amarena");
        wino1.setOpis("delikatna nuta denaturatu");
        wino1.setRocznik(2017);

        Category category2= new Category();
        category2.setName("Półwytrawne");
        CategoryDao categoryDao =  new CategoryDao();
        try {
            categoryDao.createOrUpdate(category2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e){
            e.printStackTrace();
        }

        Category category3= new Category();
        category3.setName("półsłodkie");
        Producent producent2 = new Producent();
        producent2.setImię("Janusz");
        producent2.setNazwisko("Zbazin");
        Wino wino2= new Wino();
        wino2.setCategory(category3);
        wino2.setProducent(producent2);
        wino2.setNazwa("Kadarka");
        wino2.setOpis("delikatna nuta denaturatu");
        wino2.setRocznik(2017);

        Category category4= new Category();
        category4.setName("słodkie");
        Producent producent3 = new Producent();
        producent3.setImię("Ewa");
        producent3.setNazwisko("Zbazin");
        Wino wino3= new Wino();
        wino3.setCategory(category4);
        wino3.setProducent(producent3);
        wino3.setNazwa("Wino");
        wino3.setOpis("delikatna nuta denaturatu");
        wino3.setRocznik(2017);

        WineDao wineDao = new WineDao();
        try {
            wineDao.createOrUpdate(wino1);
            wineDao.createOrUpdate(wino2);
            wineDao.createOrUpdate(wino3);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();
    }
}
