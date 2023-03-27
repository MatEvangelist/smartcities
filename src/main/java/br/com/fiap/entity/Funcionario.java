package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@Column(name = "cd_funcionario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nm_comprador", nullable = false, length = 100)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_nascimento")
	private Calendar dataNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_admissao")
	private Calendar dataAdmissao;

	@Column(name = "vl_salario_bruto")
	private double salarioBruto;

	@Column(name = "vl_salario_liquido")
	@Formula("vl_salario_bruto*0.8")
	private double salarioLiquido;

	public Funcionario() {

	}

	public Funcionario(int id, String nome, Calendar dataNascimento, Calendar dataAdmissao, double salarioBruto,
			double salarioLiquido) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

}
