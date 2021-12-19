package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Serializable :para os objetos serem transformados em sequência de Bytes, é opicional,seja gravado em arquivos,seja trafegados em rede

	private Integer id;
	private String name;
	
	public Departamento() {

	}

	public Departamento(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id);
	//para que os objetos possam ser comparados pelo conteúdo e não pela referência de ponteiros
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + name + "]";
	}
	
}
