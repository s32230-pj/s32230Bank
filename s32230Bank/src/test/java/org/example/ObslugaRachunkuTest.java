package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ObslugaRachunkuTest {
	private ObslugaRachunku obslugaRachunku;
	private PrzechowywanieRachunkow przechowywanieRachunkow;

	@BeforeEach
	public void przygotujDane() {
		przechowywanieRachunkow = new PrzechowywanieRachunkow();
		obslugaRachunku = new ObslugaRachunku(przechowywanieRachunkow);
	}

	@Test
	public void testPrzelew() {
		// Given
		Rachunek rach1 = new Rachunek(10, 1500);
		przechowywanieRachunkow.dodajRachunek(rach1);

		// When
		Status wynik = obslugaRachunku.wykonajPrzelew(10, 1500, 500);

		// Then
		assertThat(wynik).isEqualTo(Status.ZAAKCEPTOWANE);
	}

	@Test
	public void testWyplata() {
		// Given
		Rachunek rach2 = new Rachunek(20, 3000);
		przechowywanieRachunkow.dodajRachunek(rach2);

		// When
		Status wynik = obslugaRachunku.wykonajPrzelew(20, 3000, 1000);

		// Then
		assertThat(wynik).isEqualTo(Status.ZAAKCEPTOWANE);
	}
}
