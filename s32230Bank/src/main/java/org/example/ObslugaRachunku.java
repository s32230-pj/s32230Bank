package org.example;

import org.springframework.stereotype.Service;

@Service
public class ObslugaRachunku {
    private final PrzechowywanieRachunkow bazaRachunkow;

    public ObslugaRachunku(PrzechowywanieRachunkow bazaRachunkow) {
        this.bazaRachunkow = bazaRachunkow;
    }

    public Status wykonajPrzelew(int numerKlienta, double stanKonta, double kwotaPrzelewu) {
        double nowyStan = stanKonta - kwotaPrzelewu;
        if (nowyStan < 0) {
            return Status.ODRZUCONE;
        }
        return Status.ZAAKCEPTOWANE;
    }

    public Status zasilKonto(int idKlienta, double stanKonta, double kwota) {
        double zaktualizowanyStan = stanKonta + kwota;
        return Status.ZAAKCEPTOWANE;
    }

    public void wyswietlInformacje(int numerKlienta, double stanKonta) {
        System.out.println("Klient: " + numerKlienta + ", Stan: " + stanKonta);
    }
}
