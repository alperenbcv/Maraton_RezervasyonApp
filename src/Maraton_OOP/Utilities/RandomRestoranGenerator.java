package Maraton_OOP.Utilities;

import Uygulamalar.Maraton_OOP.Databases.RestoranDB;
import Uygulamalar.Maraton_OOP.Entities.Restoran;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRestoranGenerator {
	
	private static final List<List<String>> RESTORAN_ADLARI = new ArrayList<>();
	static {
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Asya Sofrasi", "Sakura Sushi", "Dragon Wok", "Zen Garden",
		                                            "Lotus Blossom"))); // ASYA_MUTFAGI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("El Taco", "Cantina Mexicana", "Fiesta Mexicana", "Burrito House", "Tequila Sunrise"))); // MEKSIKA_MUTFAGI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Pasta Fresca", "La Dolce Vita", "Trattoria Roma", "Pizzeria Napoli", "Cucina Italiana"))); // ITALYAN_MUTFAGI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Evde Yemek", "Anne Eli", "Ev Lezzetleri", "Sicak Sofra", "Nefis " +
				"Yemekler"))); // EV_YEMEGI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Kebapci", "Ocakbasi", "Kebap Duragi", "Anadolu Kebap", "Meshur " +
				"Kebap"))); // KEBAB
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Le Bistro", "Cafe de Paris", "Le Gourmet", "Maison de Cuisine",
		                                            "La Petite France"))); // FRANSIZ_MUTFAGI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Tatli Kosesi", "Sekerpare", "Tatli Dunyasi", "Pasta Evi",
		                                            "Dessert Delight"))); // TATLI
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Burger King", "McDonald's", "Fast Food Express", "Quick Bites", "Speedy Snacks"))); // FAST_FOOD
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Vegan House", "Yesil Mutfak", "Vegan Life", "Bitkisel " +
				"Lezzetler", "Vegan Dunyasi"))); // VEGAN
		RESTORAN_ADLARI.add(new ArrayList<>(List.of("Deniz Lezzetleri", "Balik Evi", "Denizden Gelen", "Mavi Deniz",
		                                            "Deniz Sofrasi"))); // DENIZ_URUNLERI
	}
	
	private static final String[] RESTORAN_ADRESLERI = {
			"Istiklal Caddesi", "Bagdat Caddesi", "Nisantasi", "Kadikoy", "Besiktas",
			"Bakirkoy", "Sisli", "Etiler", "Levent", "Fatih"
	};
	
	private static final String[] RESTORAN_TELEFONLARI = {
			"0212 555 1234", "0212 666 5678", "0212 777 9012", "0212 888 3456", "0212 999 7890"
	};
	
	private static final Random RANDOM = new Random();
	
	public static void generateRandomRestoran(int sayi) {
		for (int i = 0; i < sayi; i++) {
			
			ERestoranTur restoranTur;
			String ad;
			List<String> isimListesi;
			do {
				restoranTur = ERestoranTur.values()[RANDOM.nextInt(ERestoranTur.values().length)];
				isimListesi = RESTORAN_ADLARI.get(restoranTur.ordinal());
			} while (isimListesi.isEmpty());
			
			ad = isimListesi.remove(RANDOM.nextInt(isimListesi.size()));
			
			String adres = RESTORAN_ADRESLERI[RANDOM.nextInt(RESTORAN_ADRESLERI.length)];
			String tel = RESTORAN_TELEFONLARI[RANDOM.nextInt(RESTORAN_TELEFONLARI.length)];
			
			Restoran restoran = new Restoran(ad, adres, tel);
			int resKapasite=RANDOM.nextInt(50) + 50; //50-100 arasi
			restoran.setRestoranKapasite(resKapasite);
			restoran.setRestoranBosKapasite(RANDOM.nextInt(resKapasite));
			restoran.setRestoranDurum(ERestoranDurum.values()[RANDOM.nextInt(ERestoranDurum.values().length)]);
			restoran.setRestoranTur(restoranTur);
			restoran.setRestoranFiyat(ERestoranFiyat.values()[RANDOM.nextInt(ERestoranFiyat.values().length)]);
			RestoranDB.restoranEkle(restoran);
		}
	}
	
}