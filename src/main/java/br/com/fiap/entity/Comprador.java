package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_comprador")
public class Comprador {
	
	@Id
	@Column(name = "cd_comprador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nm_comprador", 
			nullable = false, 
			length = 100)
	private String nome;
		
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_senha", nullable = false, length = 25)
	private String senha;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_primeira_transacao")
	private Calendar dataPrimeiraTransacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private UnidadeFederacao unidadeFederacao;

	public Comprador() {
		
	}
	
	public Comprador(int id, String nome, String email, String senha, Calendar dataPrimeiraTransacao,
			Calendar dataNascimento, UnidadeFederacao unidadeFederacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataPrimeiraTransacao = dataPrimeiraTransacao;
		this.dataNascimento = dataNascimento;
		this.unidadeFederacao = unidadeFederacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataPrimeiraTransacao() {
		return dataPrimeiraTransacao;
	}

	public void setDataPrimeiraTransacao(Calendar dataPrimeiraTransacao) {
		this.dataPrimeiraTransacao = dataPrimeiraTransacao;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public UnidadeFederacao getUnidadeFederacao() {
		return unidadeFederacao;
	}

	public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
		this.unidadeFederacao = unidadeFederacao;
	}
	
	
}
