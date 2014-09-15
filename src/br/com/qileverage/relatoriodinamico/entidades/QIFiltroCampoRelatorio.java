package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class QIFiltroCampoRelatorio implements Serializable, IsSerializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String tipoNumero = "n";
	private static final String tipoBoolean = "b";
	private static final String tipoString = "s";
	private static final String tipoData = "d";

	private Double numeroValue;
	private Boolean booleanValue;
	private String stringValue;
	private Date dataValue;

	private String tipo;

	private TFiltro tipoFiltro;
	private QICampoRelatorio campoRelatorio;

	public QIFiltroCampoRelatorio()
	{
		tipo = new String();
	}

	public TFiltro getTipoFiltro()
	{
		return tipoFiltro;
	}

	public void setTipoFiltro(TFiltro tipoFiltro)
	{
		this.tipoFiltro = tipoFiltro;
	}

	public QICampoRelatorio getCampoRelatorio()
	{
		return campoRelatorio;
	}

	public void setCampoRelatorio(QICampoRelatorio campoRelatorio)
	{
		this.campoRelatorio = campoRelatorio;
	}

	public void setValue(Object value)
	{
		if (value instanceof Double)
		{
			setNumeroValue((Double) value);
		}

		if (value instanceof String)
		{
			setStringValue((String) value);
		}

		if (value instanceof Date)
		{
			setDataValue((Date) value);
		}

		if (value instanceof Boolean)
		{
			setBooleanValue((Boolean) value);
		}

	}

	public void setNumeroValue(Double value)
	{
		tipo = tipoNumero;
		numeroValue = value;
	}

	public void setStringValue(String value)
	{
		tipo = tipoString;
		stringValue = value;
	}

	public void setDataValue(Date value)
	{
		tipo = tipoData;
		dataValue = value;
	}

	public void setBooleanValue(Boolean value)
	{
		tipo = tipoBoolean;
		booleanValue = value;
	}

	public Object getValue()
	{
		if (tipo.equals(tipoNumero))
		{
			return getNumeroValue();
		}

		if (tipo.equals(tipoString))
		{
			return getStringValue();
		}

		if (tipo.equals(tipoData))
		{
			return getDataValue();
		}

		if (tipo.equals(tipoBoolean))
		{
			return getBooleanValue();
		}

		return null;
	}

	public Double getNumeroValue()
	{
		return numeroValue;
	}

	public Boolean getBooleanValue()
	{
		return booleanValue;
	}

	public String getStringValue()
	{
		return stringValue;
	}

	public Date getDataValue()
	{
		return dataValue;
	}

}
