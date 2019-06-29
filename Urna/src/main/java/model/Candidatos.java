package model;

import javax.persistence.*;
import javax.persistence.Entity;

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

    @Column(name="numero")
    private int numero;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="id")
    private int id;

    @Column(name="link")
    private String link;
    
	public String getNome() 
	{
        return nome;
    }
    
	public void setNome(String nome) 
	{
        this.nome = nome;
    }

	public String getPartido() 
	{
        return partido;
    }

	public void setPartido(String partido) 
	{
        this.partido = partido;
    }

	public int getVotos() 
	{
        return votos;
    }

	public void setVotos(int votos) 
	{
        this.votos = votos;
    }

	public int getNumero() 
	{
        return numero;
    }

	public void setNumero(int numero) 
	{
        this.numero = numero;
    }

	public int getId() 
	{
        return id;
    }

	public void setId(int id) 
	{
        this.id = id;
    }

    public String getLink() 
	{
        return link;
    }

	public void setLink(String link) 
	{
        this.link = link;
    }
}
