package Maraton_OOP.Entities;

import Uygulamalar.Maraton_OOP.Utilities.ERole;

public class Kullanici {
	private static int kullaniciCounter;
	
	private Integer kullaniciID;
	private String kullaniciKullaniciAd;
	private String kullaniciSifre;
	private String kullaniciAd;
	private String kullaniciSoyad;
	private String kullaniciTel;
	private String kullaniciEposta;
	private ERole eRole;
	
	
	public Kullanici(String kullaniciKullaniciAd, String kullaniciSifre,String kullaniciAd, String kullaniciSoyad,
	               String kullaniciTel,
	               String kullaniciEposta) {
		this.kullaniciID=++kullaniciCounter;
		this.kullaniciKullaniciAd=kullaniciKullaniciAd;
		this.kullaniciSifre=kullaniciSifre;
		this.kullaniciAd = kullaniciAd;
		this.kullaniciSoyad = kullaniciSoyad;
		this.kullaniciTel = kullaniciTel;
		this.kullaniciEposta = kullaniciEposta;
	}
	
	public Integer getKullaniciID() {
		return kullaniciID;
	}
	
	public void setKullaniciID(Integer kullaniciID) {
		this.kullaniciID = kullaniciID;
	}
	
	public String getKullaniciKullaniciAd() {
		return kullaniciKullaniciAd;
	}
	
	public void setKullaniciKullaniciAd(String kullaniciKullaniciAd) {
		this.kullaniciKullaniciAd = kullaniciKullaniciAd;
	}
	
	public String getKullaniciSifre() {
		return kullaniciSifre;
	}
	
	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	
	public String getKullaniciAd() {
		return kullaniciAd;
	}
	
	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}
	
	public String getKullaniciSoyad() {
		return kullaniciSoyad;
	}
	
	public void setKullaniciSoyad(String kullaniciSoyad) {
		this.kullaniciSoyad = kullaniciSoyad;
	}
	
	public String getKullaniciTel() {
		return kullaniciTel;
	}
	
	public void setKullaniciTel(String kullaniciTel) {
		this.kullaniciTel = kullaniciTel;
	}
	
	public String getKullaniciEposta() {
		return kullaniciEposta;
	}
	
	public void setKullaniciEposta(String kullaniciEposta) {
		this.kullaniciEposta = kullaniciEposta;
	}
	
	public ERole geteRole() {
		return eRole;
	}
	
	public void seteRole(ERole eRole) {
		this.eRole = eRole;
	}
	
	@Override
	public String toString() {
		return "Kullanici{" + "kullaniciID=" + kullaniciID + ", kullaniciKullaniciAd='" + kullaniciKullaniciAd + '\'' + ", kullaniciSifre='" + kullaniciSifre + '\'' + ", kullaniciAd='" + kullaniciAd + '\'' + ", kullaniciSoyad='" + kullaniciSoyad + '\'' + ", kullaniciTel='" + kullaniciTel + '\'' + ", kullaniciEposta='" + kullaniciEposta + '\'' + ", eRole=" + eRole + '}';
	}
}