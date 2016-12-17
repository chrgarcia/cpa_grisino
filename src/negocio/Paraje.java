package negocio;
import javax.persistence.*;

@Entity
@Table(name="parajes")
public class Paraje {

	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_provincia")
	private Provincia provincia;
	
	@Column(name="nombre")
	private String nombre;

	public Paraje(int id, Provincia provincia, String nombre) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.nombre = nombre;
	}

	public Paraje() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
