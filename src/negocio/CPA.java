package negocio;
import javax.persistence.*;

@Entity
@Table(name="cpa")
public class CPA {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="cpa")
	private String cpa;

	public CPA(int id, String cpa) {
		super();
		this.id = id;
		this.cpa = cpa;
	}

	public CPA() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpa() {
		return cpa;
	}

	public void setCpa(String cpa) {
		this.cpa = cpa;
	}



	
	
}
