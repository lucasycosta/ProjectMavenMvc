
package projeto.maven.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Filme {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String genero;
	
	public Filme() {}

	public Filme(Integer id, String nome, String genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}
}
