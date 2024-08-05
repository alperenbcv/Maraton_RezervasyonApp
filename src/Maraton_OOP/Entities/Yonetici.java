package Maraton_OOP.Entities;

import Uygulamalar.Maraton_OOP.Utilities.ERole;

public class Yonetici extends Kullanici {
	
	public Yonetici(String kullaniciKullaniciAd, String kullaniciSifre, String kullaniciAd, String kullaniciSoyad, String kullaniciTel, String kullaniciEposta) {
		super(kullaniciKullaniciAd, kullaniciSifre, kullaniciAd, kullaniciSoyad, kullaniciTel, kullaniciEposta);
		super.seteRole(ERole.ADMIN);
	}
}