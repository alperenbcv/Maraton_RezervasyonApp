package Maraton_OOP.Databases;

import Uygulamalar.Maraton_OOP.Entities.Restoran;
import Uygulamalar.Maraton_OOP.Entities.Rezervasyon;

import java.util.ArrayList;
import java.util.Iterator;

public class RezervasyonDB {
	static ArrayList<Rezervasyon> rezervasyonArrayList = new ArrayList<>();
	
	public static void rezervasyonEkle(Rezervasyon rezervasyon) {
		rezervasyonArrayList.add(rezervasyon);
		
	}
	
	public static void rezervasyonSil(Integer rezervasyonID) {
		Iterator<Rezervasyon> iterator = rezervasyonArrayList.iterator();
		while (iterator.hasNext()) {
			Rezervasyon rezervasyon = iterator.next();
			if (rezervasyon.getRezervID().equals(rezervasyonID)) {
				Restoran restoran = RestoranDB.restoranAra(rezervasyon.getRestoranID());
				if (restoran != null) {
					restoran.setRestoranBosKapasite(restoran.getRestoranBosKapasite() + rezervasyon.getRezervKisiSayi());
				}
				iterator.remove();
				System.out.println("Rezervasyonunuz iptal edilmistir.");
				return;
			}
		}
		System.out.println("Sistemde boyle bir rezervasyon bulunamadi.");
	}
	
	public static Rezervasyon rezervasyonAra(Integer rezervasyonID) {
		for (Rezervasyon rezervasyon : rezervasyonArrayList) {
			if (rezervasyon.getRezervID().equals(rezervasyonID)) {
				return rezervasyon;
			}
		}
		return null;
		
	}
	
	public static ArrayList<Rezervasyon> tumRezervListele() {
		for (Rezervasyon rezervasyon : rezervasyonArrayList) {
			System.out.println(rezervasyon);
		}
		return rezervasyonArrayList;
	}
	
	public static void rezervListByKullaniciID(Integer kullaniciID){
		for (Rezervasyon rezervasyon : rezervasyonArrayList) {
			if(rezervasyon.getKullaniciID().equals(kullaniciID))
			System.out.println(rezervasyon);
		}
	}
}