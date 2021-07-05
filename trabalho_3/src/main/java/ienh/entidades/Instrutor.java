package ienh.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instrutor")
public class Instrutor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="primeiro_nome")
	private String primeiroNome;
	
	@Column(name="segundo_nome")
	private String segundoNome;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instrutor_detalhe_id")
	private InstrutorDetalhe instrutorDetalhe;
	
	@OneToMany(mappedBy="instrutor",
				fetch = FetchType.LAZY,
				cascade={CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Curso> cursos;
	
	public Instrutor() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCurso(Curso curso) {
		
		if(cursos == null) {
			
			cursos = new ArrayList<>();
			
		}
		
		cursos.add(curso);
		curso.setInstrutor(this);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstrutorDetalhe getInstrutorDetalhe() {
		return instrutorDetalhe;
	}

	public void setInstrutorDetalhe(InstrutorDetalhe instrutorDetalhe) {
		this.instrutorDetalhe = instrutorDetalhe;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
