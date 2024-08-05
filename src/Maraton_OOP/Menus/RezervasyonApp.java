package Maraton_OOP.Menus;

import Uygulamalar.Maraton_OOP.Databases.RestoranDB;
import Uygulamalar.Maraton_OOP.Databases.RezervasyonDB;
import Uygulamalar.Maraton_OOP.Entities.Kullanici;
import Uygulamalar.Maraton_OOP.Entities.Restoran;
import Uygulamalar.Maraton_OOP.Entities.Rezervasyon;
import Uygulamalar.Maraton_OOP.Utilities.ERestoranDurum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RezervasyonApp {
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void rezervMenu(Kullanici kullanici) {
		int userInput = -1;
		do {
			System.out.println("### REZERVASYON ISLEMLERI  ###");
			System.out.println("1. Rezervasyon Yap");
			System.out.println("2. Rezervasyonlarimi Listele");
			System.out.println("3. Rezervasyonumu Kaldir");
			System.out.println("0. Geri Don");
			System.out.print("Seciminiz: ");
			try {
				userInput = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("\nGeçerli bir değer giriniz!\n");
				continue;
			}
			finally {
				sc.nextLine();
				System.out.println();
			}
			switch (userInput) {
				case 1: {
					rezervOlustur(kullanici);
					break;
				}
				case 2: {
					System.out.println("Rezervasyonlarimi Listele: ");
					
					RezervasyonDB.rezervListByKullaniciID(kullanici.getKullaniciID());
					break;
				}
				case 3: {
					System.out.println("Rezervasyon Iptali");
					System.out.println("Kaldirmak istediginiz Rezervasyonun ID'sini giriniz: ");
					RezervasyonDB.rezervasyonSil(sc.nextInt());
					
				}
				case 0: {
					break;
				}
			}
		} while (userInput != 0);
	}
	
	public static Rezervasyon rezervOlustur(Kullanici kullanici){
		int kullaniciID=kullanici.getKullaniciID();
		System.out.println("Rezervasyon yaptirmak istediniz Restoran ID giriniz: ");
		int restoranID=sc.nextInt();
		sc.nextLine();
		
		Restoran restoran= RestoranDB.restoranAra(restoranID);
		if(restoran==null){
			System.out.println("Gecersiz Restoran ID");
			return null;
		}
		
		if (restoran.getRestoranDurum() == ERestoranDurum.KAPALI) {
			System.out.println("Seçilen restoran kapalı, rezervasyon yapılamaz.");
			return null;
		}
		LocalDate rezervDate = null;
		while (rezervDate == null) {
			System.out.println("Rezervasyon tarihini giriniz: dd/MM/yyyy");
			String date = sc.nextLine();
			try {
				rezervDate = LocalDate.parse(date, formatter);
				if (rezervDate.isBefore(LocalDate.now())) {
					System.out.println("Geçmiş bir tarih giremezsiniz. Lütfen geçerli bir tarih girin.");
					rezervDate = null;
				}
			} catch (DateTimeParseException e) {
				System.out.println("Geçersiz tarih formatı. Lütfen dd/MM/yyyy formatında bir tarih girin.");
			}
		}
		System.out.println("Kac kisilik rezervasyon yaptirmak istersiniz: ");
		int kisiSayi = sc.nextInt();
		
		if (restoran.getRestoranBosKapasite() < kisiSayi) {
			System.out.println("Yeterli bos yer yok.");
			return null;
		}
		
		Rezervasyon rezervasyon=new Rezervasyon(kullaniciID,restoranID,rezervDate,kisiSayi);
		RezervasyonDB.rezervasyonEkle(rezervasyon);
		restoran.setRestoranBosKapasite(restoran.getRestoranBosKapasite() - kisiSayi);
		System.out.println("Rezervasyonunuz basariyla olusturuldu.");
		return rezervasyon;
	}
}