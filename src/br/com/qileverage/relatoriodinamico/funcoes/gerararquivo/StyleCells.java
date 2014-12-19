package br.com.qileverage.relatoriodinamico.funcoes.gerararquivo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class StyleCells
{

	protected static void celulaHeader(PdfPCell celula, Font font)
	{
		celula.setHorizontalAlignment(Phrase.ALIGN_CENTER);
		celula.setVerticalAlignment(Element.ALIGN_MIDDLE);
		celula.getColumn().setAlignment(Phrase.ALIGN_CENTER);

		celula.setPaddingTop(0f);
		celula.setPaddingBottom(10f);

		celula.setBackgroundColor(BaseColor.GRAY);

		if (font != null)
		{
			font.setFamily(FontFamily.HELVETICA.toString());
			font.setSize(15);
			font.setStyle(Font.BOLD);
			font.setColor(BaseColor.WHITE);
		}
	};

	protected static void celulaConteudo(PdfPCell celula, QIControleCorDeFundoCelula controleCorDeFundo)
	{
		celula.setHorizontalAlignment(Element.ALIGN_LEFT);
		celula.setVerticalAlignment(Element.ALIGN_BOTTOM);

		celula.setPaddingTop(0f);
		celula.setPaddingBottom(7f);

		if (controleCorDeFundo != null)
		{
			celula.setBackgroundColor(controleCorDeFundo.actual());
		}
	};

	protected static void celulaLabelTotalLinhas(PdfPCell celula, Font font)
	{
		celula.setPaddingTop(0f);
		celula.setPaddingBottom(7f);

	};

	protected static void celulaTotalLinhas(PdfPCell celula, Font font)
	{
		celula.setHorizontalAlignment(Element.ALIGN_LEFT);
		celula.setVerticalAlignment(Element.ALIGN_MIDDLE);

		celula.setPaddingTop(0f);
		celula.setPaddingBottom(7f);

		if (font != null)
		{
			font.setStyle(Font.NORMAL);
		}
	};

	protected static void celulaTitulo(PdfPCell celula, Font font)
	{
		celula.setHorizontalAlignment(Element.ALIGN_CENTER);
		celula.setVerticalAlignment(Element.ALIGN_MIDDLE);

		celula.setPaddingTop(0f);
		celula.setPaddingBottom(7f);

		if (font != null)
		{
			font.setFamily(FontFamily.HELVETICA.toString());
			font.setSize(18);
			font.setStyle(Font.BOLD);
			font.setColor(BaseColor.BLACK);
		}
	};

	protected static void celulaDataCriacao(PdfPCell celula, Font font)
	{
		celula.setHorizontalAlignment(Element.ALIGN_CENTER);
		celula.setVerticalAlignment(Element.ALIGN_MIDDLE);

		celula.setPaddingTop(0f);
		celula.setPaddingBottom(7f);

		if (font != null)
		{
			font.setFamily(FontFamily.HELVETICA.toString());
			font.setSize(12);
			font.setStyle(Font.NORMAL);
			font.setColor(BaseColor.BLACK);
		}
	};

	protected static void celulaImagem(PdfPCell celula)
	{
		celula.setHorizontalAlignment(Element.ALIGN_CENTER);
		celula.setVerticalAlignment(Element.ALIGN_MIDDLE);

		celula.setPaddingTop(0.5f);
		celula.setPaddingBottom(0.5f);
	};

}
