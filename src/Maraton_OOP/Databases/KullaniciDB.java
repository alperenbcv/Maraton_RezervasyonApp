package Maraton_OOP.Databases;

import Uygulamalar.Maraton_OOP.Entities.*;

import java.util.ArrayList;

public class KullaniciDB {
	static ArrayList<Kullanici> kullaniciArrayList=new ArrayList<>();
	
	public static void kullaniciEkle(Kullanici kullanici){
		kullaniciArrayList.add(kullanici);
	}
	
	public static void kullaniciSil(Kullanici kullanici){
		kullaniciArrayList.remove(kullanici);
	}
	
	public static Kullanici kullaniciAraById(Integer id){
		for (Kullanici kullanici: kullaniciArrayList){
			if(kullanici.getKullaniciID().equals(id)){
				return kullanici;
			}
		}
		return null;
		
	}
	
	public static Kullanici kullaniciAraByNamePw(String id, String pw){
		for (Kullanici kullanici: kullaniciArrayList){
			if(kullanici.getKullaniciKullaniciAd().equals(id) && kullanici.getKullaniciSifre().equals(pw)){
				return kullanici;
			}
		}
		return null;
	}
}