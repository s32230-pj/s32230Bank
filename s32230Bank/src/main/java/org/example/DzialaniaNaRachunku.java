package org.example;

public class DzialaniaNaRachunku {
    private Rachunek rachunek;
    private double kwota;
    private Status status;

    public DzialaniaNaRachunku(Rachunek rachunek, double kwota, Status status) {
        this.rachunek = rachunek;
        this.kwota = kwota;
        this.status = status;
    }

    public Rachunek pobierzRachunek() {
        return rachunek;
    }

    public void ustawRachunek(Rachunek rachunek) {
        this.rachunek = rachunek;
    }

    public double pobierzKwote() {
        return kwota;
    }

    public void ustawKwote(double kwota) {
        this.kwota = kwota;
    }

    public Status pobierzStatus() {
        return status;
    }

    public void ustawStatus(Status status) {
        this.status = status;
    }
}
