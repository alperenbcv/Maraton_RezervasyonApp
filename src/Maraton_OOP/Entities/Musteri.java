package Maraton_OOP.Entities;

import Uygulamalar.Maraton_OOP.Utilities.ERole;

public class Musteri extends Kullanici{
	
	
	public Musteri(String kullaniciKullaniciAd, String kullaniciSifre, String kullaniciAd, String kullaniciSoyad, String kullaniciTel, String kullaniciEposta) {
		super(kullaniciKullaniciAd, kullaniciSifre, kullaniciAd, kullaniciSoyad, kullaniciTel, kullaniciEposta);
		super.seteRole(ERole.MUSTERI);
	}
}