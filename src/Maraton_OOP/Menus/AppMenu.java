package Maraton_OOP.Menus;

import Uygulamalar.Maraton_OOP.Entities.Kullanici;
import Uygulamalar.Maraton_OOP.Utilities.RandomRestoranGenerator;

import java.util.Scanner;

public class AppMenu {
	static Scanner sc = new Scanner(System.in);
	
	
	public static void appMenu() {
		int userInput = -1;
		do {
			System.out.println("### RESTORAN ISLEMLERI  ###");
			System.out.println("1. Restoran Islemleri");
			System.out.println("2. Kullanici Islemleri");
			System.out.println("3. Rezervasyon Islemleri");
			System.out.println("0. Cikis Yap");
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
						Kullanici currentKullanici = KullaniciApp.getCurrentKullanici();
						if(currentKullanici!=null) {
							RestoranApp.restoranMenu(currentKullanici);
						}
						else {
						if(currentKullanici==null)
								System.out.println("Once giris yapmalisiniz!\n");
							}
					break;
				}
				case 2: {
					KullaniciApp.kullaniciApp();
					break;
				}
				case 3: {
					Kullanici currentKullanici=KullaniciApp.getCurrentKullanici();
					if (currentKullanici != null) {
						RezervasyonApp.rezervMenu(currentKullanici);
					} else {
						System.out.println("Once giris yapmalisiniz!\n");
					}
					break;
				}
				case 9:{ //RASTGELE RESTORAN OLUSTURMA
					RandomRestoranGenerator.generateRandomRestoran(10);
				}
				case 0: {
					break;
				}
			}
		} while (userInput != 0);
	}
}