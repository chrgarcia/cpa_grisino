package negocio;
import javax.persistence.*;

@Entity
@Table(name="cp_1974")
public class CP {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="cod_postal")
	private int cod_postal;

	public CP(int id, int cod_postal) {
		super();
		this.id = id;
		this.cod_postal = cod_postal;
	}

	public CP() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	
	
}
