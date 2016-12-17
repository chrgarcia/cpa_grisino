package negocio;
import javax.persistence.*;

@Entity
@Table(name="calles")
public class Calle {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre_completo")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_localidad")
	private Localidad localidad;
	
	@Column(name="barrio")
	private String barrio;

	
	public Calle(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Calle() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
}
