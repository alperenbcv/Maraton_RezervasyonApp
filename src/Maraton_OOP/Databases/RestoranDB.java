package Maraton_OOP.Databases;

import Uygulamalar.Maraton_OOP.Entities.Restoran;
import Uygulamalar.Maraton_OOP.Utilities.ERestoranDurum;

import java.util.ArrayList;

public class RestoranDB {
	static ArrayList<Restoran> restoranArrayList = new ArrayList<>();
	
	public static void restoranEkle(Restoran restoran){
		restoranArrayList.add(restoran);
		System.out.println("Restoraniniz basariyla sistemimize eklenmistir.");
	}
	
	public static void restoranSil(Integer restoranID){
		for (Restoran restoran:restoranArrayList){
			if(restoran.getRestoranID()==restoranID){
				restoranArrayList.remove(restoranID);
				System.out.println("Restoraniniz basariyla sistemden silinmistir.");
			}
			if(restoran.getRestoranID()!=restoranID){
				System.out.println("Sistemde boyle bir Restoran bulunamadi.");
			}
		}
	}
	
	public static ArrayList<Restoran> acikRestoranlariListele() {
		ArrayList<Restoran> acikRestoranlar = new ArrayList<>();
		for (Restoran restoran : restoranArrayList) {
			if (restoran.getRestoranDurum() == ERestoranDurum.ACIK) {
				acikRestoranlar.add(restoran);
				System.out.println(restoran.getRestoranID()+" "+restoran.getRestoranAd()+" "+restoran.getRestoranDurum());
			}
		}
		return acikRestoranlar;
	}
	
	public static Restoran restoranAra(Integer restoranID){
		for(Restoran restoran:restoranArrayList) {
			if (restoran.getRestoranID() == restoranID) {
				return restoran;
			}
			}
		System.out.println("Sistemde boyle bir Restoran bulunamadi.");
		return null;
		}
	
	public static ArrayList<Restoran> restoranlariListele(){
		for (Restoran restoran:restoranArrayList){
			System.out.println(restoran.getRestoranID()+" "+restoran.getRestoranAd()+" "+restoran.getRestoranDurum());
		}
		return restoranArrayList;
	}
	
	public static void addAllRestoran(ArrayList<Restoran> restorans){
		restoranArrayList.addAll(restorans);
	}
}