package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * Created by niewiel on 20.05.17.
 */
public class TopMenuButtonsController {

    public static final String OPEN_WINIARNIA_FXML = "/fxml/OpenWiniarnia.fxml";
    public static final String OPEN_LISTA_WIN_FXML = "/fxml/OpenListaWin.fxml";
    public static final String OPEN_STATYSTYKI_FXML = "/fxml/openStatistics.fxml";
    public static final String ADD_WINE_FXML = "/fxml/AddWine.fxml";
    public static final String ADD_CATEGORY_FXML = "/fxml/AddCategory.fxml";
    public static final String ADD_PRODUCENT_FXML = "/fxml/AddProducent.fxml";


    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openWiniarnia(){
        mainController.setCenter(OPEN_WINIARNIA_FXML);

    }

    @FXML
    public void openListaWin(){
        mainController.setCenter(OPEN_LISTA_WIN_FXML);
    }

    @FXML
    public void openStatystyki(){
        mainController.setCenter(OPEN_STATYSTYKI_FXML);

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    @FXML
    public void addWine() {
        resetToggleButton();

        mainController.setCenter(ADD_WINE_FXML);
    }

    private void resetToggleButton() {
        if (toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }


    @FXML
    public void addCategory(ActionEvent actionEvent) {
        resetToggleButton();
        mainController.setCenter(ADD_CATEGORY_FXML);
    }

    @FXML
    public void addProducent(ActionEvent actionEvent) {
        resetToggleButton();
        mainController.setCenter(ADD_PRODUCENT_FXML);
    }
}
