package model;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

/**
 * Secao
 */
@Entity
@Table(name="secao_eleitoral")
public class Secao {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_zona", nullable = false)
    private Zona fk_id_zona;

    @Id
    @Column (name="id_secao")
    private int id_secao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="fk_id_secao", targetEntity = Usuario.class)
    private List<Usuario> usuario;

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
	 * @return the id_secao
	 */
	public int getId_secao() 
	{
		return id_secao;
	}

	/**
	 * @param id_secao the id_secao to set
	 */
	public void setId_secao(int id_secao) 
	{
		this.id_secao = id_secao;
	}

	/**
	 * @return the usuario
	 */
	public List<Usuario> getUsuario() 
	{
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuario> usuario) 
	{
		this.usuario = usuario;
	}
}