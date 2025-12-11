package controller;

import com.example.demo.model.Kniha;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class KnihaController {
    @FXML private ListView<Kniha> knihaListView;

    public void initialize(){
        knihaListView.getItems().add(new Kniha("Hawk", "Tuah", 1969));
        knihaListView.getItems().add(new Kniha("Glorbo", "Florbo", 1467));
    }

}

