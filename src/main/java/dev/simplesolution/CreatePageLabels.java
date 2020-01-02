package dev.simplesolution;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDPageLabelRange;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;

public class CreatePageLabels {
	
	public static void main(String[] args)
    {
        try (PDDocument document = new PDDocument())
        {
        	for(int i = 0; i < 10; i++) {
        		document.addPage(new PDPage());
        	}
            
            PDPageLabels pageLabels = new PDPageLabels(document);
            PDPageLabelRange pageLabelRangeRoman = new PDPageLabelRange();
            pageLabelRangeRoman.setStyle(PDPageLabelRange.STYLE_ROMAN_UPPER);
            pageLabelRangeRoman.setPrefix("Chapter ");
            pageLabelRangeRoman.setStart(1);
            pageLabels.setLabelItem(0, pageLabelRangeRoman);
            
            PDPageLabelRange pageLabelRangeLetters = new PDPageLabelRange();
            pageLabelRangeLetters.setStyle(PDPageLabelRange.STYLE_LETTERS_UPPER);
            pageLabelRangeLetters.setPrefix("Part ");
            pageLabelRangeLetters.setStart(1);
            pageLabels.setLabelItem(2, pageLabelRangeLetters);
            
            
            PDPageLabelRange pageLabelRangeDecimal = new PDPageLabelRange();
            pageLabelRangeDecimal.setStyle(PDPageLabelRange.STYLE_DECIMAL);
            pageLabelRangeDecimal.setPrefix("Page ");
            pageLabelRangeDecimal.setStart(1);
            pageLabels.setLabelItem(5, pageLabelRangeDecimal);
            
            document.getDocumentCatalog().setPageLabels(pageLabels);
            
            document.save("D:\\SimpleSolution\\DocumentPageLabels.pdf");
        }catch (IOException e) {
			e.printStackTrace();
		}
    }

}
