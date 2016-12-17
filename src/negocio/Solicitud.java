package negocio;
import javax.persistence.*;

@Entity
@Table(name="solicitudes")
public class Solicitud {

	/*Atributos - 	ID	Calle	Altura	CP	Localidad	Provincia*/
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="altura")
	private int altura;
	
	@Column(name="cp")
	private int cp;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="cpa")
	private String cpa;
	
	@Column(name="metodo")
	private String metodo;

	
	public Solicitud(int id, String calle, int altura, int cp, String localidad, String provincia) {
		super();
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cpa = "";
		this.metodo = "";
	}

	public Solicitud() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getCpa() {
		return cpa;
	}

	public void setCpa(String cpa) {
		this.cpa = cpa;
	}

}
