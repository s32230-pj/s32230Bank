package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrzechowywanieRachunkow {
    private List<Rachunek> listaRachunkow;

    public PrzechowywanieRachunkow() {
        this.listaRachunkow = new ArrayList<>();
    }

    public void dodajRachunek(Rachunek rachunek) {
        listaRachunkow.add(rachunek);
    }

    public List<Rachunek> pobierzWszystkieRachunki() {
        return listaRachunkow;
    }
}
