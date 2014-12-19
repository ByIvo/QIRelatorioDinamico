package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class QICampoRelatorio implements Serializable, IsSerializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeCampo;
	private TCampo tipoCampo;

	private String nomeColunaBanco;

	public QICampoRelatorio()
	{
		nomeCampo = "";
	}

	public QICampoRelatorio(TCampo tipoCampo)
	{
		this.tipoCampo = tipoCampo;
	}

	public String getNomeCampo()
	{
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo)
	{
		this.nomeCampo = nomeCampo;
	}

	public TCampo getTipoCampo()
	{
		return tipoCampo;
	}

	public void setTipoCampo(TCampo tipoCampo)
	{
		this.tipoCampo = tipoCampo;
	}

	public String getNomeColunaBanco()
	{
		return nomeColunaBanco;
	}

	public void setNomeColunaBanco(String nomeColunaBanco)
	{
		this.nomeColunaBanco = nomeColunaBanco;
	}

}
