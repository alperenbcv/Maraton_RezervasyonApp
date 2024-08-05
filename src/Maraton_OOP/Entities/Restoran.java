package Maraton_OOP.Entities;

import Uygulamalar.Maraton_OOP.Utilities.ERestoranDurum;
import Uygulamalar.Maraton_OOP.Utilities.ERestoranFiyat;
import Uygulamalar.Maraton_OOP.Utilities.ERestoranTur;

public class Restoran {
	
	private static int restoranCounter;
	
	private Integer restoranID;
	private String restoranAd;
	private String restoranAdres;
	private String restoranTel;
	private int restoranKapasite;
	private int restoranBosKapasite;
	private ERestoranDurum restoranDurum;
	private ERestoranTur restoranTur;
	private ERestoranFiyat restoranFiyat;
	
	public Restoran(String restoranAd, String restoranAdres, String restoranTel) {
		this.restoranAd = restoranAd;
		this.restoranAdres = restoranAdres;
		this.restoranTel = restoranTel;
		this.restoranID = ++restoranCounter;
	}
	
	public Integer getRestoranID() {
		return restoranID;
	}
	
	public void setRestoranID(Integer restoranID) {
		this.restoranID = restoranID;
	}
	
	public String getRestoranAd() {
		return restoranAd;
	}
	
	public void setRestoranAd(String restoranAd) {
		this.restoranAd = restoranAd;
	}
	
	public String getRestoranAdres() {
		return restoranAdres;
	}
	
	public void setRestoranAdres(String restoranAdres) {
		this.restoranAdres = restoranAdres;
	}
	
	public String getRestoranTel() {
		return restoranTel;
	}
	
	public void setRestoranTel(String restoranTel) {
		this.restoranTel = restoranTel;
	}
	
	public int getRestoranKapasite() {
		return restoranKapasite;
	}
	
	public void setRestoranKapasite(int restoranKapasite) {
		this.restoranKapasite = restoranKapasite;
	}
	
	public ERestoranDurum getRestoranDurum() {
		return restoranDurum;
	}
	
	public void setRestoranDurum(ERestoranDurum restoranDurum) {
		this.restoranDurum = restoranDurum;
	}
	
	public ERestoranTur getRestoranTur() {
		return restoranTur;
	}
	
	public void setRestoranTur(ERestoranTur restoranTur) {
		this.restoranTur = restoranTur;
	}
	
	public ERestoranFiyat getRestoranFiyat() {
		return restoranFiyat;
	}
	
	public void setRestoranFiyat(ERestoranFiyat restoranFiyat) {
		this.restoranFiyat = restoranFiyat;
	}
	
	public int getRestoranBosKapasite() {
		return restoranBosKapasite;
	}
	
	public void setRestoranBosKapasite(int restoranBosKapasite) {
		this.restoranBosKapasite = restoranBosKapasite;
	}
	
	@Override
	public String toString() {
		return "Restoran{" + "restoranID=" + restoranID + ", restoranAd='" + restoranAd + '\'' + ", restoranAdres='" + restoranAdres + '\'' + ", restoranTel='" + restoranTel + '\'' + ", restoranKapasite=" + restoranKapasite + ", restoranBosKapasite=" + restoranBosKapasite + ", restoranDurum=" + restoranDurum + ", restoranTur=" + restoranTur + ", restoranFiyat=" + restoranFiyat + '}';
	}
}