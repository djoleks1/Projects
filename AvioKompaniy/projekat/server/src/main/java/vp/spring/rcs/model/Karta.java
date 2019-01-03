package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Karta {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ime;
	private String prezime;
	private String brojSedista;
	@ManyToOne
	private TipKarte tipKarte;
	
	
	
	public Karta() {
		super();
	}



	public Karta(Long id, String ime, String prezime, String brojSedista, TipKarte tipKarte) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brojSedista = brojSedista;
		this.tipKarte = tipKarte;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getBrojSedista() {
		return brojSedista;
	}



	public void setBrojSedista(String brojSedista) {
		this.brojSedista = brojSedista;
	}



	public TipKarte getTipKarte() {
		return tipKarte;
	}



	public void setTipKarte(TipKarte tipKarte) {
		this.tipKarte = tipKarte;
	}
	
	
	
}
