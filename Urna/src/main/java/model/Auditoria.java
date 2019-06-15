package model;

import java.util.Date;
import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

@Entity
@Table(name="auditoria")
public class Auditoria 
{
    @Column(name="data_alteracao", nullable = false)
    private Date data_alteracao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_titulo", nullable = false)
    private Usuario fk_titulo;
    
    @Column(name="descricao", nullable = false)
    private String descricao;
    
    @Id 
    @Column(name="id", nullable = false)
    private int id;

    /**
     * @return the data_alteracao
     */
    public Date getData_alteracao() 
    {
        return data_alteracao;
    }

    /**
     * @param data_alteracao the data_alteracao to set
     */
    public void setData_alteracao(Date data_alteracao) 
    {
        this.data_alteracao = data_alteracao;
    }

    /**
     * @return the fk_titulo
     */
    public Usuario getFk_titulo() 
    {
        return fk_titulo;
    }

    /**
     * @param fk_titulo the fk_titulo to set
     */
    public void setFk_titulo(Usuario fk_titulo) 
    {
        this.fk_titulo = fk_titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() 
    {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) 
    {
        this.id = id;
    }       
}