package com.example.demo.controller;

import com.example.demo.model.Kniha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KnihaControllerObservable {
    @FXML private ListView<Kniha> knihaListView;

    private ObservableList<Kniha> knihy = FXCollections.observableArrayList();

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

    @FXML
    private TextField hledatField;

    boolean a = true;


    public void initialize(){
        knihy.add(new Kniha("Hawk", "Tuah", 1969));
        knihy.add(new Kniha("Glorbo", "Florbo", 1467));

        knihaListView.setItems(knihy);
    }

    public void handleVyberKnihu(){
        Kniha selected = knihaListView.getSelectionModel().getSelectedItem();
        if (selected != null){
            titulLabel.setText(selected.getTitul());
            autorLabel.setText(selected.getAutor());
            rokLabel.setText(String.valueOf(selected.getRokVydani()));

            titulField.setText(titulLabel.getText());
            autorField.setText(autorLabel.getText());
            rokField.setText(String.valueOf(rokLabel.getText()));
        }
        else{
            System.err.println("Nebyla vybrána kniha");
        }




    }

    public void handlePridejKnihu(){
        if (titulField.getText().isEmpty() ||  autorField.getText().isEmpty() || rokField.getText().isEmpty()){
            System.err.println("Nebyly vyplněny všechny informace");
        }
        else {


            try {
                int rok = Integer.parseInt(rokField.getText());
                a = true;
            } catch (NumberFormatException e){
                System.err.println("V roku smí být jen čísla");
                a = false;
            }

            if (a){
                String titul = titulField.getText();
                String autor = autorField.getText();
                int rok = Integer.parseInt(rokField.getText());

                knihy.add(new Kniha(titul, autor, rok));
                knihaListView.setItems(knihy);

                titulField.clear();
                autorField.clear();
                rokField.clear();

                Kniha prvni = knihaListView.getItems().get(0);

                titulLabel.setText(titul);
                autorLabel.setText(autor);
                rokLabel.setText(String.valueOf(rok));
            }
            else {
                System.err.println("V roce musí být jen čísla");
            }




        }
    }

    public void handleSmazatKnihu(){
        Kniha selected = knihaListView.getSelectionModel().getSelectedItem();

        if (selected != null){
            knihy.remove(selected);
            knihaListView.setItems(knihy);
        }
        else{
            System.err.println("Musí být vybrána kniha");
        }
    }

    public void handleUpravKnihu(){
        Kniha selected = knihaListView.getSelectionModel().getSelectedItem();


        if (selected != null){
            handleSmazatKnihu();
            handlePridejKnihu();
        }
        else {
            System.err.println("Není vybráná kniha");
        }
    }

    public void handleHledatKnihu(){
        if (hledatField.getText().isEmpty()){
            System.err.println("Pole hledání je prázdné");
        }
        else {
            if (knihy.contains(hledatField.getText())){
                for (Kniha k : knihy){
                    if (hledatField.getText().equals(k.getTitul())){
                        knihaListView.getSelectionModel().select(k);
                        handleVyberKnihu();
                        break;
                    }
                }
            }
            else {
                System.err.println("Zadaná kniha se nenachází v seznamu");
            }


        }
    }

}

