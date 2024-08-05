package Maraton_OOP.Menus;

import Uygulamalar.Maraton_OOP.Databases.KullaniciDB;
import Uygulamalar.Maraton_OOP.Entities.Kullanici;
import Uygulamalar.Maraton_OOP.Entities.Musteri;
import Uygulamalar.Maraton_OOP.Entities.Yonetici;

import java.util.Scanner;

public class KullaniciApp {
	static Scanner sc = new Scanner(System.in);
	private static Kullanici currentKullanici = null;
	
	public static Kullanici getCurrentKullanici() {
		return currentKullanici;
	}
	
	public static void setCurrentKullanici(Kullanici kullanici) {
		currentKullanici = kullanici;
	}
	
	public static Kullanici kullaniciApp() {
		int userInput = -1;
		do {
			System.out.println("### KULLANICI ISLEMLERI  ###");
			if (currentKullanici == null) {
				System.out.println("1. Kayit Ol");
				System.out.println("2. Giris Yap");
			} else {
				System.out.println("3. Kullanici Bilgilerini Goruntule");
				System.out.println("4. Rezervasyonlarini Goruntule");
				System.out.println("5. Cikis Yap");
			}
			System.out.println("0. Geri Don");
			System.out.print("Seciminiz: ");
			try {
				userInput = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\nGecerli bir deger giriniz!\n");
				continue;
			} finally {
				sc.nextLine();
				System.out.println();
			}
			if (currentKullanici == null) {
				switch (userInput) {
					case 1: {
						System.out.println("Kullanici Kayit Ekrani");
						currentKullanici = kullaniciKayit();
						break;
					}
					case 2: {
						System.out.println("Kullanici Giris Ekrani");
						currentKullanici = kullaniciGiris();
						break;
					}
					case 0: {
						return currentKullanici;
					}
				}
			} else {
				switch (userInput) {
					case 3: {
						if (currentKullanici != null) {
							System.out.println(currentKullanici);
						} else {
							System.out.println("Lutfen önce giris yapin.");
						}
						break;
					}
					case 4: {
						if (currentKullanici != null) {
							RezervasyonApp.rezervMenu(currentKullanici);
						} else {
							System.out.println("Lutfen once giris yapin.");
						}
						break;
					}
					case 5: {
						System.out.println("Basariyla cikis yaptiniz.");
						currentKullanici = null;
						break;
					}
					case 0: {
						return currentKullanici;
					}
				}
			}
		} while (userInput != 0);
		return currentKullanici;
	}
	
	private static Kullanici kullaniciKayit() {
		System.out.println("Kullanici Adinizi Giriniz: ");
		String kullaniciID = sc.nextLine();
		System.out.println("Sifrenizi Giriniz: ");
		String kullaniciSifre = sc.nextLine();
		System.out.println("Adinizi Giriniz: ");
		String kullaniciAd = sc.nextLine();
		System.out.println("Soyadinizi Giriniz: ");
		String kullaniciSoyad = sc.nextLine();
		System.out.println("Telefon Numaranizi Giriniz: ");
		String kullaniciTel = sc.nextLine();
		System.out.println("Epostanizi Giriniz: ");
		String kullaniciMail = sc.nextLine();
		
		Kullanici kullanici;
		if ("admin".equalsIgnoreCase(kullaniciID)) {
			kullanici = new Yonetici(kullaniciID, kullaniciSifre, kullaniciAd, kullaniciSoyad, kullaniciTel, kullaniciMail);
		} else {
			kullanici = new Musteri(kullaniciID, kullaniciSifre, kullaniciAd, kullaniciSoyad, kullaniciTel, kullaniciMail);
		}
		
		KullaniciDB.kullaniciEkle(kullanici);
		return kullanici;
	}
	
	private static Kullanici kullaniciGiris() {
		System.out.println("Kullanici Adi: ");
		String kullaniciID = sc.nextLine();
		System.out.println("Sifre: ");
		String kullaniciSifre = sc.nextLine();
		Kullanici kullanici = KullaniciDB.kullaniciAraByNamePw(kullaniciID, kullaniciSifre);
		if (kullanici == null) {
			System.out.println("Kullanici adi ve sifre eslesmiyor. Tekrar deneyiniz.");
			return null;
		}
		System.out.println("Basariyla giris yaptiniz.");
		return kullanici;
	}
}