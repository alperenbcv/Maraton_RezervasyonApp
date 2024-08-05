package Maraton_OOP.Entities;

import java.time.LocalDate;

public class Rezervasyon {
	
	private static int rezervCounter;
	
	private Integer rezervID;
	private Integer kullaniciID;
	private Integer restoranID;
	private LocalDate rezervTarih;
	private Integer rezervKisiSayi;
	
	public Rezervasyon(Integer kullaniciID, Integer restoranID, LocalDate rezervTarih, Integer rezervKisiSayi) {
		this.rezervID=++rezervCounter;
		this.kullaniciID = kullaniciID;
		this.restoranID = restoranID;
		this.rezervTarih = rezervTarih;
		this.rezervKisiSayi = rezervKisiSayi;
	}
	
	public Integer getRezervID() {
		return rezervID;
	}
	
	public void setRezervID(Integer kullaniciID) {
		this.rezervID = rezervID;
	}
	
	public Integer getKullaniciID() {
		return kullaniciID;
	}
	
	public void setKullaniciID(Integer kullaniciID) {
		this.kullaniciID = kullaniciID;
	}
	
	public Integer getRestoranID() {
		return restoranID;
	}
	
	public void setRestoranID(Integer restoranID) {
		this.restoranID = restoranID;
	}
	
	public LocalDate getRezervTarih() {
		return rezervTarih;
	}
	
	public void setRezervTarih(LocalDate rezervTarih) {
		this.rezervTarih = rezervTarih;
	}
	
	public Integer getRezervKisiSayi() {
		return rezervKisiSayi;
	}
	
	public void setRezervKisiSayi(Integer rezervKisiSayi) {
		this.rezervKisiSayi = rezervKisiSayi;
	}
	
	@Override
	public String toString() {
		return "Rezervasyon{" + "rezervID='" + rezervID + '\'' + ", kullaniciID='" + kullaniciID + '\'' + ", restoranID='" + restoranID + '\'' + ", rezervTarih=" + rezervTarih + ", rezervKisiSayi=" + rezervKisiSayi + '}';
	}
}