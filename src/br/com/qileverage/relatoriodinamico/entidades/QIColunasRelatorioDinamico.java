package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QIColunasRelatorioDinamico implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QICampoRelatorio campoRelatorio;
	private List<Object> resultados;
	private Iterator<Object> iterator;
	private Object footerValue;

	private Integer proporcao;

	public QIColunasRelatorioDinamico()
	{
		proporcao = 1;
		resultados = new ArrayList<Object>();
		iterator = resultados.iterator();
	}

	public QIColunasRelatorioDinamico(QICampoRelatorio campoRelatorio, List<Object> resultados)
	{
		super();
		this.campoRelatorio = campoRelatorio;
		this.resultados = resultados;
		iterator = resultados.iterator();
		alterarProporcaoNomeColuna();
	}

	public QICampoRelatorio getCampoRelatorio()
	{
		return campoRelatorio;
	}

	public void setCampoRelatorio(QICampoRelatorio campoRelatorio)
	{
		this.campoRelatorio = campoRelatorio;
		alterarProporcaoNomeColuna();
	}

	public List<Object> getResultados()
	{
		return resultados;
	}

	public void setResultados(List<Object> resultados)
	{
		this.resultados = resultados;
		iterator = resultados.iterator();
	}

	public boolean hasNext()
	{
		return iterator.hasNext();
	}

	public Object next()
	{
		return iterator.next();
	}

	public Integer getProporcao()
	{
		return proporcao;
	}

	public void setProporcao(Integer proporcao)
	{
		this.proporcao = proporcao;
	}

	public void atualizarProporcao(String value, int min)
	{
		int length = value.length();

		if (length < proporcao)
		{
			return;
		}
		else
		{
			setProporcao(min < length ? length : min);
		}
	}

	public Object getFooterValue()
	{
		return footerValue;
	}

	public void setFooterValue(Object footerValue)
	{
		this.footerValue = footerValue;
	}

	public void atualizarIterator()
	{
		iterator = resultados.iterator();
	}

	private void alterarProporcaoNomeColuna()
	{
		String[] nomes = campoRelatorio.getNomeCampo().split(" ");

		for (String nome : nomes)
		{
			atualizarProporcao(nome, 0);
		}
	}
}
