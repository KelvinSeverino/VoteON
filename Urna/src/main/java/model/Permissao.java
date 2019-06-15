package model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Permissao
 */
@Entity
@Table(name="permissao_usr")
public class Permissao {
    
    @Column(name="nome")
    private String nome;

    @Id
    @Column(name="nivel")
    private int nivel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="fk_nivel")
    private List<Usuario> Usuario;

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
	 * @return the nivel
	 */
	public int getNivel() 
	{
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) 
	{
		this.nivel = nivel;
	}

	/**
	 * @return the usuario
	 */
	public List<Usuario> getUsuario() 
	{
		return Usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuario> usuario) 
	{
		Usuario = usuario;
	}
}