package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avion {

	@Id
	@GeneratedValue
	private Long id;
	
	private int brojLeta;
	
	private String vremeLeta;
	@ManyToOne
	private Karta karta;
	@ManyToOne
	private Prevoznik prevoznik;
	
	public Avion() {
		super();
	}

	public Avion(Long id, int brojLeta, String vremeLeta, Karta karta, Prevoznik prevoznik) {
		super();
		this.id = id;
		this.brojLeta = brojLeta;
		this.vremeLeta = vremeLeta;
		this.karta = karta;
		this.prevoznik = prevoznik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojLeta() {
		return brojLeta;
	}

	public void setBrojLeta(int brojLeta) {
		this.brojLeta = brojLeta;
	}

	public String getVremeLeta() {
		return vremeLeta;
	}

	public void setVremeLeta(String vremeLeta) {
		this.vremeLeta = vremeLeta;
	}

	public Karta getKarta() {
		return karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	
	
}
