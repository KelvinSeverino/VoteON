package model;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

/**
 * Uf
 */
@Entity
@Table (name="uf")
public class Uf 
{
    @Column(name="nome")
    private String nome;

    @Id
    @Column(name="id_uf")
    private int id_uf;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="fk_id_uf", targetEntity = Cidade.class)
    private List<Cidade> cidade;

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
	 * @return the id_uf
	 */
	public int getId_uf() 
	{
		return id_uf;
	}

	/**
	 * @param id_uf the id_uf to set
	 */
	public void setId_uf(int id_uf) 
	{
		this.id_uf = id_uf;
	}

	/**
	 * @return the cidade
	 */
	public List<Cidade> getCidade() 
	{
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(List<Cidade> cidade) 
	{
		this.cidade = cidade;
	}
}