package Maraton_OOP.Menus;

import Uygulamalar.Maraton_OOP.Databases.RestoranDB;
import Uygulamalar.Maraton_OOP.Entities.Kullanici;
import Uygulamalar.Maraton_OOP.Entities.Restoran;
import Uygulamalar.Maraton_OOP.Utilities.ERole;

import java.util.Scanner;

public class RestoranApp {
	static Scanner sc = new Scanner(System.in);
	
	public static void restoranMenu(Kullanici currentKullanici) {
		int userInput = -1;
		do {
			System.out.println("### RESTORAN ISLEMLERI  ###");
			System.out.println("1. Restoranlari Listele");
			System.out.println("2. Restorani Detayli Goruntule");
			if (currentKullanici.geteRole() == ERole.ADMIN) {
				System.out.println("3. Restoran Ekle");
				System.out.println("4. Restoran Kaldir");
			}
			System.out.println("0. Geri Don");
			System.out.print("Seciminiz: ");
			try {
				userInput = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\nGeçerli bir değer giriniz!\n");
				continue;
			} finally {
				sc.nextLine();
				System.out.println();
			}
			switch (userInput) {
				case 1: {
					restoranlariListeleMenu();
					break;
				}
				case 2: {
					System.out.println("Detayli goruntulemek istediginiz Restoran No. giriniz:");
					int restoranID = sc.nextInt();
					sc.nextLine();
					Restoran restoran = RestoranDB.restoranAra(restoranID);
					if (restoran != null) {
						System.out.println(restoran);
					}
					break;
				}
				case 3: {
					if (currentKullanici.geteRole() == ERole.ADMIN) {
						System.out.println("Restoraninizin bilgilerini giriniz.");
						System.out.println("Restoraninizin Adi: ");
						String restoranAd = sc.nextLine();
						System.out.println("Restoraninizin Adresi: ");
						String restoranAdres = sc.nextLine();
						System.out.println("Restoraninizin Telefon Numarasi: ");
						String restoranTel = sc.nextLine();
						Restoran restoran = new Restoran(restoranAd, restoranAdres, restoranTel);
						RestoranDB.restoranEkle(restoran);
					} else {
						System.out.println("Bu işlemi gerçekleştirme yetkiniz yok.");
					}
					break;
				}
				case 4: {
					if (currentKullanici.geteRole() == ERole.ADMIN) {
						System.out.println("Kaldirmak istediginiz Restoran ID'sini giriniz: ");
						int restoranID = sc.nextInt();
						RestoranDB.restoranSil(restoranID);
					} else {
						System.out.println("Bu islemi gerceklestirme yetkiniz yok.");
					}
					break;
				}
				case 0: {
					break;
				}
			}
		} while (userInput != 0);
	}
	
	public static void restoranlariListeleMenu() {
		int userInput = -1;
		do {
			System.out.println("### RESTORANLARI LISTELEME  ###");
			System.out.println("1. Acik Restoranlar");
			System.out.println("2. Tum Restoranlar");
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
			switch (userInput) {
				case 1: {
					RestoranDB.acikRestoranlariListele();
					break;
				}
				case 2: {
					RestoranDB.restoranlariListele();
					break;
				}
				case 0: {
					return; // Alt menüden çık ve ana menüye dön
				}
			}
		} while (userInput != 0);
	}
}