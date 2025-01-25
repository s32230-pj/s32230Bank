package org.example;

import org.springframework.stereotype.Service;

@Service
public class ObslugaRachunku {
    private final PrzechowywanieRachunkow przechowywanieRachunkow;

    public ObslugaRachunku(PrzechowywanieRachunkow przechowywanieRachunkow) {
        this.przechowywanieRachunkow = przechowywanieRachunkow;
    }

    public Status wykonajPrzelew(int numerKlienta, double kwotaPrzelewu) {
        Rachunek rachunek = znajdzRachunek(numerKlienta);
        if (rachunek == null) {
            System.out.println("Klient o numerze " + numerKlienta + " nie istnieje.");
            return Status.ODRZUCONE;
        }

        double stanKonta = rachunek.pobierzStanKonta();
        if (stanKonta < kwotaPrzelewu) {
            System.out.println("Niewystarczające środki na koncie klienta o numerze " + numerKlienta + ".");
            return Status.ODRZUCONE;
        }

        rachunek.aktualizujStanKonta(stanKonta - kwotaPrzelewu);
        System.out.println("Przelew wykonany. Nowy stan konta klienta o numerze " + numerKlienta + ": " + rachunek.pobierzStanKonta());
        return Status.ZAAKCEPTOWANE;
    }

    public Status zasilKonto(int numerKlienta, double kwotaZasilenia) {
        Rachunek rachunek = znajdzRachunek(numerKlienta);
        if (rachunek == null) {
            System.out.println("Klient o numerze " + numerKlienta + " nie istnieje.");
            return Status.ODRZUCONE;
        }

        double stanKonta = rachunek.pobierzStanKonta();
        rachunek.aktualizujStanKonta(stanKonta + kwotaZasilenia);
        System.out.println("Zasilenie konta wykonane. Nowy stan konta klienta o numerze " + numerKlienta + ": " + rachunek.pobierzStanKonta());
        return Status.ZAAKCEPTOWANE;
    }

    public void wyswietlInformacje(int numerKlienta) {
        Rachunek rachunek = znajdzRachunek(numerKlienta);
        if (rachunek != null) {
            System.out.println("Klient: " + numerKlienta + ", Stan konta: " + rachunek.pobierzStanKonta());
        } else {
            System.out.println("Klient o numerze " + numerKlienta + " nie istnieje.");
        }
    }

    private Rachunek znajdzRachunek(int numerKlienta) {
        return przechowywanieRachunkow.pobierzWszystkieRachunki().stream()
                .filter(rachunek -> rachunek.pobierzNumerKlienta() == numerKlienta)
                .findFirst()
                .orElse(null);
    }
}
