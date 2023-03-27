package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoId implements Serializable {

	private int usuario;
	
	private int estabelecimento;
	
	public AvaliacaoId() {
		
	}

	public AvaliacaoId(int usuario, int estabelecimento) {
		super();
		this.usuario = usuario;
		this.estabelecimento = estabelecimento;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(int estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estabelecimento;
		result = prime * result + usuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		if (estabelecimento != other.estabelecimento)
			return false;
		if (usuario != other.usuario)
			return false;
		return true;
	}


}
