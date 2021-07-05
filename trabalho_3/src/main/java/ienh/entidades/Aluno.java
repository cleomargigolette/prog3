package ienh.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="primeiro_nome")
	private String primeiroNome;
	
	@Column(name="ultimo_nome")
	private String ultimoNome;
	
	@ManyToMany(cascade={CascadeType.DETACH, CascadeType.MERGE,
			             CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="curso_aluno",
				joinColumns=@JoinColumn(name="aluno_id"),
				inverseJoinColumns=@JoinColumn(name="curso_id"))
	private List<Curso> cursos;
	
	public Aluno() {
	
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

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void addCurso(Curso curso) {
		
		if(cursos == null) {
			
			cursos = new ArrayList<>();
			
		}
		
		cursos.add(curso);
		
	}
	
}
