package com.example.demo.controller;

import com.example.demo.model.Kniha;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KnihaController {
    @FXML private ListView<Kniha> knihaListView;

    @FXML
    private Label titulLabel;

    @FXML
    private Label autorLabel;

    @FXML
    private Label rokLabel;

    @FXML
    private TextField titulField;

    @FXML
    private TextField autorField;

    @FXML
    private TextField rokField;

    public void initialize(){
        knihaListView.getItems().add(new Kniha("Hawk", "Tuah", 1969));
        knihaListView.getItems().add(new Kniha("Glorbo", "Florbo", 1467));
    }

    public void handleVyberKnihu(){


        titulLabel.setText(knihaListView.getSelectionModel().getSelectedItem().getTitul());
        autorLabel.setText(knihaListView.getSelectionModel().getSelectedItem().getAutor());
        rokLabel.setText(String.valueOf(knihaListView.getSelectionModel().getSelectedItem().getRokVydani()));
    }

    public void handlePridejKnihu(){
        String titul = titulField.getText();
        String autor = autorField.getText();
        int rok = Integer.parseInt(rokField.getText());

        knihaListView.getItems().add(new Kniha(titul, autor, rok));

        titulField.clear();
        autorField.clear();
        rokField.clear();

        Kniha prvni = knihaListView.getItems().get(0);

        titulLabel.setText(titul);
        autorLabel.setText(autor);
        rokLabel.setText(String.valueOf(rok));
    }

}

