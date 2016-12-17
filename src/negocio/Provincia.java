package negocio;
import javax.persistence.*;

@Entity
@Table(name="provincias")
public class Provincia {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;

	
	/*Constructores*/
	public Provincia() {
		super();
	}

	public Provincia(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
	//GyS
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
