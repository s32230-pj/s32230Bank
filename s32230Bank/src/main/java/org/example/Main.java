package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final PrzechowywanieRachunkow bazaRachunkow;
    private final ObslugaRachunku obslugaRachunku;

    public Main(PrzechowywanieRachunkow bazaRachunkow, ObslugaRachunku obslugaRachunku) {
        this.bazaRachunkow = bazaRachunkow;
        this.obslugaRachunku = obslugaRachunku;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        inicjalizujProces();
    }

    public void inicjalizujProces() {
        Rachunek rach1 = new Rachunek(10, 1500);
        Rachunek rach2 = new Rachunek(20, 2500);
        Rachunek rach3 = new Rachunek(30, 3500);

        bazaRachunkow.dodajRachunek(rach1);
        bazaRachunkow.dodajRachunek(rach2);
        bazaRachunkow.dodajRachunek(rach3);

        System.out.println("Dodano rachunki do bazy:");
        for (Rachunek rachunek : bazaRachunkow.pobierzWszystkieRachunki()) {
            System.out.println("Numer klienta: " + rachunek.pobierzNumerKlienta() + ", Stan konta: " + rachunek.pobierzStanKonta());
        }
    }
}
