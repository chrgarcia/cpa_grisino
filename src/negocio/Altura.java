package negocio;
import javax.persistence.*;

//id,id_calle,desde,hasta,id_cpa,id_cp_1974

@Entity
@Table(name="alturas")
public class Altura {

	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_calle")
	private Calle calle;
	
	@ManyToOne
	@JoinColumn(name="id_cp_1974")
	private CP cp;
	
	@ManyToOne
	@JoinColumn(name="id_cpa")
	private CPA cpa;
	
	
	@Column(name="desde")
	private int desde;
	
	@Column(name="hasta")
	private int hasta;

	






	public Altura(int id, Calle calle, CP cp, CPA cpa, int desde, int hasta) {
		super();
		this.id = id;
		this.calle = calle;
		this.cp = cp;
		this.cpa = cpa;
		this.desde = desde;
		this.hasta = hasta;
	}

	public Altura() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}


	public CPA getCpa() {
		return cpa;
	}

	public void setCpa(CPA cpa) {
		this.cpa = cpa;
	}

	public CP getCp() {
		return cp;
	}

	public void setCp(CP cp) {
		this.cp = cp;
	}


	
	
	
	
}
