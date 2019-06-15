package model;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Candidatos
 */
@Entity
@Table(name="candidatos")
public class Candidatos
{
    @Column(name="nome")
    private String nome;
    
    @Column(name="partido")
    private String partido;
    
    @Column(name="votos")
    private int votos;
    
    @Id
    @Column(name="numero")
    private int numero;

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
	 * @return the partido
	 */
	public String getPartido() 
	{
		return partido;
	}

	/**
	 * @param partido the partido to set
	 */
	public void setPartido(String partido) 
	{
		this.partido = partido;
	}

	/**
	 * @return the votos
	 */
	public int getVotos() 
	{
		return votos;
	}

	/**
	 * @param votos the votos to set
	 */
	public void setVotos(int votos) 
	{
		this.votos = votos;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() 
	{
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) 
	{
		this.numero = numero;
	}
}