package model;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

/**
 * Zona
 */
@Entity
@Table(name="zona")
public class Zona {
    @Id
    @Column(name="id_zona")
    private int id_zona;

    @Column(name="nome")
    private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cidade", nullable = false)
    private Cidade fk_id_cidade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="fk_id_zona", targetEntity = Secao.class)
	private List<Secao> secao;

	/**
	 * @return the id_zona
	 */
	public int getId_zona() 
	{
		return id_zona;
	}

	/**
	 * @param id_zona the id_zona to set
	 */
	public void setId_zona(int id_zona) 
	{
		this.id_zona = id_zona;
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
	 * @return the fk_id_cidade
	 */
	public Cidade getFk_id_cidade() 
	{
		return fk_id_cidade;
	}

	/**
	 * @param fk_id_cidade the fk_id_cidade to set
	 */
	public void setFk_id_cidade(Cidade fk_id_cidade) 
	{
		this.fk_id_cidade = fk_id_cidade;
	}

	/**
	 * @return the secao
	 */
	public List<Secao> getSecao() 
	{
		return secao;
	}

	/**
	 * @param secao the secao to set
	 */
	public void setSecao(List<Secao> secao) 
	{
		this.secao = secao;
	}
}