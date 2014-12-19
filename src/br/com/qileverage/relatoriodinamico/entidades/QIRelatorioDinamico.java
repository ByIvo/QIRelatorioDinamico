package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class QIRelatorioDinamico implements Serializable, IsSerializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;

	private String classRelatorio;

	private List<QICampoRelatorio> camposRelatorio;
	private List<QIFiltroCampoRelatorio> filtroCamposRelatorio;
	private List<QICampoRelatorio> camposRelatorioQueSeraoExibidos;

	public QIRelatorioDinamico()
	{
		camposRelatorio = new ArrayList<QICampoRelatorio>();
		camposRelatorioQueSeraoExibidos = new ArrayList<QICampoRelatorio>();
		filtroCamposRelatorio = new ArrayList<QIFiltroCampoRelatorio>();
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public List<QICampoRelatorio> getCamposRelatorio()
	{
		return camposRelatorio;
	}

	public QIRelatorioDinamico adicionarNovoCampo(QICampoRelatorio campoRelatorio)
	{
		camposRelatorio.add(campoRelatorio);

		return this;
	}

	public QIRelatorioDinamico adicionarNovoCampoExibido(QICampoRelatorio campoRelatorio)
	{
		camposRelatorioQueSeraoExibidos.add(campoRelatorio);

		return this;
	}

	public QIRelatorioDinamico setListaCampoExibido(List<QICampoRelatorio> listaCampoRelatorio)
	{
		camposRelatorioQueSeraoExibidos.clear();
		camposRelatorioQueSeraoExibidos.addAll(listaCampoRelatorio);

		return this;
	}

	public QIRelatorioDinamico adicionarListaCampoExibido(List<QICampoRelatorio> listaCampoRelatorio)
	{
		camposRelatorioQueSeraoExibidos.addAll(listaCampoRelatorio);

		return this;
	}

	public List<QIFiltroCampoRelatorio> getFiltrosCamposRelatorio()
	{
		return filtroCamposRelatorio;
	}

	public void adicionarFiltro(QIFiltroCampoRelatorio filtroCampoRelatorio)
	{
		this.filtroCamposRelatorio.add(filtroCampoRelatorio);
	}

	public void limpar()
	{
		this.filtroCamposRelatorio.clear();
	}

	public void removerFiltro(QIFiltroCampoRelatorio filtroCampoRelatorio)
	{
		this.filtroCamposRelatorio.remove(filtroCampoRelatorio);
	}

	public List<QICampoRelatorio> getCamposRelatorioQueSeraoExibidos()
	{
		return camposRelatorioQueSeraoExibidos;
	}

	public String getClassRelatorio()
	{
		return classRelatorio;
	}

	public void setClassRelatorio(String classRelatorio)
	{
		this.classRelatorio = classRelatorio;
	}

}
