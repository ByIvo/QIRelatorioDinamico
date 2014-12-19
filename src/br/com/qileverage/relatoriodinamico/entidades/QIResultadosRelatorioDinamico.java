package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.qileverage.relatoriodinamico.funcoes.gerararquivo.QIFormatterCamposRelatorioDinamico;

import com.google.gwt.user.client.rpc.IsSerializable;

public class QIResultadosRelatorioDinamico extends ArrayList<QIColunasRelatorioDinamico> implements  Serializable, IsSerializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QIFormatterCamposRelatorioDinamico formatter;

	private String caminhoImagem = "";
	private QIRelatorioDinamico relatorioDinamico;

	public QIResultadosRelatorioDinamico()
	{
		formatter = new QIFormatterCamposRelatorioDinamico();
	}

	public QIFormatterCamposRelatorioDinamico getFormatter()
	{
		return formatter;
	}

	public void setFormatter(QIFormatterCamposRelatorioDinamico formatter)
	{
		this.formatter = formatter;
	}

	public String getCaminhoImagem()
	{
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem)
	{
		this.caminhoImagem = caminhoImagem;
	}

	public String getNomeRelatorio()
	{
		return relatorioDinamico.getNome();
	}

	public QIRelatorioDinamico getRelatorioDinamico()
	{
		return relatorioDinamico;
	}

	public void setRelatorioDinamico(QIRelatorioDinamico relatorioDinamico)
	{
		this.relatorioDinamico = relatorioDinamico;
	}

	public void atualizarIterators()
	{
		for (int i = 0; i < this.size(); i++)
		{
			this.get(i).atualizarIterator();
		}
	}

}