package br.com.qileverage.relatoriodinamico.funcoes.gerararquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import br.com.qileverage.relatoriodinamico.entidades.QIColunasRelatorioDinamico;
import br.com.qileverage.relatoriodinamico.entidades.QIResultadosRelatorioDinamico;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class QIControleRelatorioDinamico
{
	// public static void main(String[] args)
	// {
	// QIResultadosRelatorioDinamico resultados = new
	// QIResultadosRelatorioDinamico();
	//
	// resultados.setCaminhoImagem("D:\\Projetos\\QI Leverage\\Clientes\\Einsteen10\\Projeto Stout\\Implementação\\StoutWEB\\war\\img\\logo.png");
	// resultados.setNomeRelatorio("Relatório de nada");
	//
	// for (int j = 0; j < 5; j++)
	// {
	// java.util.List<Object> lista = new ArrayList<Object>();
	// for (int i = 0; i < 150; i++)
	// {
	// lista.add("Affz");
	// }
	//
	// QIColunarRelatorioDinamico coluna = new QIColunarRelatorioDinamico();
	// coluna.setCampoRelatorio(new QICampoRelatorio("Teste", TCampo.TEXTO));
	// coluna.setResultados(lista);
	//
	// resultados.add(coluna);
	// }
	//
	// java.util.List<Object> lista = new ArrayList<Object>();
	// double soma = 0;
	// for (int i = 0; i < 150; i++)
	// {
	// double sorted = (Math.random() * 10000) + 500;
	// lista.add(sorted);
	// soma += sorted;
	// }
	//
	// QIColunarRelatorioDinamico coluna = new QIColunarRelatorioDinamico();
	// coluna.setCampoRelatorio(new QICampoRelatorio("Numeros",
	// TCampo.VALOR_MONETARIO));
	// coluna.setFooterValue(soma);
	// coluna.setResultados(lista);
	//
	// resultados.add(coluna);
	//
	// try
	// {
	// gerarArquivoPdfRelatorio(resultados, "D:\\test_relatorio_dinamico.pdf");
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	//
	// }

	public static void gerarArquivoPdfRelatorio(QIResultadosRelatorioDinamico resultados, String fileName) throws Exception
	{
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());

		try
		{
			File arquivoRelatorio = new File(fileName.substring(0, fileName.lastIndexOf(File.separator)));

			if (!arquivoRelatorio.exists())
			{
				arquivoRelatorio.mkdirs();
			}
			PdfWriter.getInstance(document, new FileOutputStream(fileName));

			document.open();
			document.add(criarCabecalhoRelatorio(resultados));
			document.add(criarTabelaDados(resultados));
			document.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	private static PdfPTable criarCabecalhoRelatorio(QIResultadosRelatorioDinamico resultados)
	{
		PdfPTable tableCabecalho = new PdfPTable(3);
		tableCabecalho.setWidthPercentage(100);
		tableCabecalho.setSpacingAfter(20);

		try
		{
			tableCabecalho.setWidths(new int[]
			{ 1, 3, 1 });

			createCabecalhoImagem(resultados, tableCabecalho);
			createCabecalhoTexto(resultados, tableCabecalho);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return tableCabecalho;
	}

	private static void queimarCelulaCabecalho(PdfPTable tableCabecalho) throws Exception
	{
		PdfPCell cell = new PdfPCell();
		cell.setRowspan(2);
		cell.setBorder(0);

		tableCabecalho.addCell(cell);
	}

	private static void createCabecalhoTexto(QIResultadosRelatorioDinamico resultados, PdfPTable tableCabecalho) throws Exception
	{
		PdfPCell cell;
		Font font;

		font = new Font();
		cell = new PdfPCell(new Phrase(resultados.getNomeRelatorio(), font));
		cell.setBorder(0);

		StyleCells.celulaTitulo(cell, font);
		tableCabecalho.addCell(cell);

		queimarCelulaCabecalho(tableCabecalho);

		font = new Font();
		cell = new PdfPCell(new Phrase(resultados.getFormatter().getDateTimeFormatter().format(new Date()), font));
		cell.setBorder(0);
		StyleCells.celulaDataCriacao(cell, font);
		tableCabecalho.addCell(cell);
	}

	private static void createCabecalhoImagem(QIResultadosRelatorioDinamico resultados, PdfPTable tableCabecalho) throws Exception
	{
		PdfPCell cell = new PdfPCell();
		cell.setRowspan(2);
		cell.setBorder(0);

		if (!resultados.getCaminhoImagem().isEmpty())
		{
			cell.addElement(Image.getInstance(resultados.getCaminhoImagem()));
		}

		StyleCells.celulaImagem(cell);
		tableCabecalho.addCell(cell);
	}

	private static PdfPTable criarTabelaDados(QIResultadosRelatorioDinamico resultados)
	{
		int sizeTable = resultados.size();

		if (sizeTable == 0)
		{
			sizeTable = 1;
		}
		PdfPTable table = new PdfPTable(sizeTable);
		table.setWidthPercentage(100);
		table.setHeaderRows(2);

		criarHeader(resultados, table);
		criarDados(resultados, table);
		atualizarProporcoesEFooter(resultados, table);

		return table;
	}

	private static void criarHeader(QIResultadosRelatorioDinamico resultados, PdfPTable table)
	{
		criarHeaderTotalLinhas(resultados, table);
		criarHeaderColunas(resultados, table);
	}

	private static void criarHeaderColunas(QIResultadosRelatorioDinamico resultados, PdfPTable table)
	{
		PdfPCell cell;

		for (QIColunasRelatorioDinamico coluna : resultados)
		{
			Font font = new Font(FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLACK);
			cell = new PdfPCell();

			cell.addElement(new Phrase(coluna.getCampoRelatorio().getNomeCampo(), font));

			StyleCells.celulaHeader(cell, font);
			table.addCell(cell);
		}
	}

	private static void criarHeaderTotalLinhas(QIResultadosRelatorioDinamico resultados, PdfPTable table)
	{
		PdfPCell cell;
		Font font;
		// Cria linha total

		if (table.getNumberOfColumns() > 2)
		{
			cell = new PdfPCell();
			cell.setColspan(table.getNumberOfColumns() - 2);
			cell.setBorderWidthRight(0);
			table.addCell(cell);
		}

		font = new Font();
		cell = new PdfPCell();
		cell.setBorderWidthLeft(0f);

		cell.addElement(new Phrase("Total:", font));

		StyleCells.celulaLabelTotalLinhas(cell, null);
		table.addCell(cell);

		int totalResultados = 0;
		if (!resultados.isEmpty())
		{
			totalResultados = resultados.get(0).getResultados().size();
		}

		font = new Font();
		cell = new PdfPCell();
		cell.addElement(new Phrase(totalResultados + "", font));

		StyleCells.celulaTotalLinhas(cell, font);
		table.addCell(cell);
	}

	private static void criarDados(QIResultadosRelatorioDinamico resultados, PdfPTable table)
	{
		PdfPCell dataCell;
		QIFormatterCamposRelatorioDinamico formatterDados = new QIFormatterCamposRelatorioDinamico();

		QIControleCorDeFundoCelula controleCorDeFundo = new QIControleCorDeFundoCelula();

		controleCorDeFundo.addItem(BaseColor.WHITE);
		controleCorDeFundo.addItem(BaseColor.LIGHT_GRAY);

		resultados.atualizarIterators();
		infinite: while (true)
		{
			for (QIColunasRelatorioDinamico coluna : resultados)
			{
				if (coluna.hasNext())
				{
					String textoFormatado = formatterDados.formatar(coluna.getCampoRelatorio().getTipoCampo(), coluna.next());

					coluna.atualizarProporcao(textoFormatado, 0);

					dataCell = new PdfPCell();
					dataCell.addElement(new Phrase(textoFormatado));

					StyleCells.celulaConteudo(dataCell, controleCorDeFundo);
					table.addCell(dataCell);
				}
				else
				{
					break infinite;
				}
			}
			controleCorDeFundo.next();
		}
	}

	private static void atualizarProporcoesEFooter(QIResultadosRelatorioDinamico resultados, PdfPTable table)
	{
		int[] widths = new int[resultados.size()];

		for (int i = 0; i < resultados.size(); i++)
		{
			atualizarFooter(resultados, resultados.get(i), table);
			widths[i] = resultados.get(i).getProporcao();
		}

		try
		{
			table.setWidths(widths);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
	}

	private static void atualizarFooter(QIResultadosRelatorioDinamico resultados, QIColunasRelatorioDinamico coluna, PdfPTable table)
	{
		PdfPCell dataCell = new PdfPCell();

		if (coluna.getFooterValue() != null)
		{
			String textoFormatado = resultados.getFormatter().formatar(coluna.getCampoRelatorio().getTipoCampo(), coluna.getFooterValue());

			coluna.atualizarProporcao(textoFormatado, 0);

			dataCell.addElement(new Phrase(textoFormatado));
		}

		table.addCell(dataCell);
	}
}
