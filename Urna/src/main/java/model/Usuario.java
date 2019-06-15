package model;

import java.util.Date;
import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

@Entity
@Table (name="usuario")
public class Usuario 
{	
	@Id
	@Column(name="titulo", nullable = false)
	private String titulo;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="nascimento", nullable = false)
	private Date nascimento;
	
	@Column(name="emissao_titulo", nullable = false)
	private Date emissaotitulo;

	@Column(name="cpf", nullable = false)
	private String cpf;
	
	@Column(name="senha", nullable = false)
	private String senha;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_zona", nullable = false)
	private Zona fk_id_zona;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_secao", nullable = false)
	private Secao fk_id_secao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_nivel", nullable = false)
	private Permissao fk_nivel;
	
	@Column(name="habilitado")
	private boolean habilitado;

	@Column(name="votado")
	private boolean votado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="fk_titulo", targetEntity = Auditoria.class)
    private List<Auditoria> auditorias;

	/**
	 * @return the titulo
	 */
	public String getTitulo() 
	{
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() 
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	/**
	 * @return the nascimento
	 */
	public Date getNascimento() 
	{
		return nascimento;
	}

	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(Date nascimento) 
	{
		this.nascimento = nascimento;
	}

	/**
	 * @return the emissaotitulo
	 */
	public Date getEmissaotitulo() 
	{
		return emissaotitulo;
	}

	/**
	 * @param emissaotitulo the emissaotitulo to set
	 */
	public void setEmissaotitulo(Date emissaotitulo) 
	{
		this.emissaotitulo = emissaotitulo;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() 
	{
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() 
	{
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}

	/**
	 * @return the fk_id_zona
	 */
	public Zona getFk_id_zona() 
	{
		return fk_id_zona;
	}

	/**
	 * @param fk_id_zona the fk_id_zona to set
	 */
	public void setFk_id_zona(Zona fk_id_zona) 
	{
		this.fk_id_zona = fk_id_zona;
	}

	/**
	 * @return the fk_id_secao
	 */
	public Secao getFk_id_secao() 
	{
		return fk_id_secao;
	}

	/**
	 * @param fk_id_secao the fk_id_secao to set
	 */
	public void setFk_id_secao(Secao fk_id_secao) 
	{
		this.fk_id_secao = fk_id_secao;
	}

	/**
	 * @return the fk_nivel
	 */
	public Permissao getFk_nivel() 
	{
		return fk_nivel;
	}

	/**
	 * @param fk_nivel the fk_nivel to set
	 */
	public void setFk_nivel(Permissao fk_nivel)
	{
		this.fk_nivel = fk_nivel;
	}

	/**
	 * @return the habilitado
	 */
	public boolean isHabilitado() 
	{
		return habilitado;
	}

	/**
	 * @param habilitado the habilitado to set
	 */
	public void setHabilitado(boolean habilitado) 
	{
		this.habilitado = habilitado;
	}

	/**
	 * @return the votado
	 */
	public boolean isVotado() 
	{
		return votado;
	}

	/**
	 * @param votado the votado to set
	 */
	public void setVotado(boolean votado) 
	{
		this.votado = votado;
	}

	/**
	 * @return the auditorias
	 */
	public List<Auditoria> getAuditorias() 
	{
		return auditorias;
	}

	/**
	 * @param auditorias the auditorias to set
	 */
	public void setAuditorias(List<Auditoria> auditorias) 
	{
		this.auditorias = auditorias;
	}
}
