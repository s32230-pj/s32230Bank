package org.example;

public class Rachunek {
    private int numerKlienta;
    private double stanKonta;

    public Rachunek(int numerKlienta, double stanKonta) {
        this.numerKlienta = numerKlienta;
        this.stanKonta = stanKonta;
    }

    public int pobierzNumerKlienta() {
        return numerKlienta;
    }

    public void ustawNumerKlienta(int numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    public double pobierzStanKonta() {
        return stanKonta;
    }

    public void aktualizujStanKonta(double stanKonta) {
        this.stanKonta = stanKonta;
    }
}
