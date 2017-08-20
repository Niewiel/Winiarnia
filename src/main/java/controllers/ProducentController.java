package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelFx.ProducentModel;
import utils.DialogsUtils;
import utils.exceptions.ApplicationException;

public class ProducentController {


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Button addButton;

    private ProducentModel producentModel;


    public void initialize(){
        this.producentModel=new ProducentModel();
        this.producentModel.producentFxObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.producentModel.producentFxObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty()));
    }


    public void addProducentOnAction() {
        try {
            this.producentModel.saveProducentInDatabase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.nameTextField.clear();
        this.surnameTextField.clear();
    }
}
