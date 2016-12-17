package negocio;
import javax.persistence.*;

@Entity
@Table(name="localidades")
public class Localidad {

	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_paraje")
	private Paraje paraje;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_cpa")
	private CPA cpa;
	
	@ManyToOne
	@JoinColumn(name="id_cp_1974")
	private CP cp;






	public Localidad(int id, Paraje paraje, String nombre, CPA cpa, CP cp) {
		super();
		this.id = id;
		this.paraje = paraje;
		this.nombre = nombre;
		this.cpa = cpa;
		this.cp = cp;
	}

	public Localidad() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Paraje getParaje() {
		return paraje;
	}

	public void setParaje(Paraje paraje) {
		this.paraje = paraje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
