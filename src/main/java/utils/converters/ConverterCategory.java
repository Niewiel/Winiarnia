package utils.converters;

import database.models.Category;
import modelFx.CategoryFx;

/**
 * Created by niewiel on 05.07.17.
 */
public class ConverterCategory {
    public static CategoryFx convertToCategoryFx(Category category){
        CategoryFx categoryFx=new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setName(category.getName());
        return categoryFx;
    }
}
