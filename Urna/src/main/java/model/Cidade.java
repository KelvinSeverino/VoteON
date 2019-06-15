package model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Cidade
 */
@Entity
@Table(name="cidade")
public class Cidade {
    @Id
    @Column (name="id_cidade")
    private int id_cidade;

    @Column (name="nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_uf", nullable = false)
    private Uf fk_id_uf;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="id_zona", targetEntity = Zona.class)
    private List<Zona> zona;

    /**
     * @return the id_cidade
     */
    public int getId_cidade() 
    {
        return id_cidade;
    }

    /**
     * @param id_cidade the id_cidade to set
     */
    public void setId_cidade(int id_cidade) 
    {
        this.id_cidade = id_cidade;
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
     * @return the fk_id_uf
     */
    public Uf getFk_id_uf() 
    {
        return fk_id_uf;
    }

    /**
     * @param fk_id_uf the fk_id_uf to set
     */
    public void setFk_id_uf(Uf fk_id_uf) 
    {
        this.fk_id_uf = fk_id_uf;
    }

    /**
     * @return the zona
     */
    public List<Zona> getZona() 
    {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(List<Zona> zona) 
    {
        this.zona = zona;
    }
}