package dev.simplesolution;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDPageLabelRange;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;

public class CreatePageLabelsLettersUpper {
	
	public static void main(String[] args)
    {
        try (PDDocument document = new PDDocument())
        {
        	for(int i = 0; i < 5; i++) {
        		document.addPage(new PDPage());
        	}
            
            PDPageLabels pageLabels = new PDPageLabels(document);
            PDPageLabelRange pageLabelRange = new PDPageLabelRange();
            pageLabelRange.setStyle(PDPageLabelRange.STYLE_LETTERS_UPPER);
            pageLabelRange.setPrefix("Part ");
            pageLabelRange.setStart(1);
            pageLabels.setLabelItem(0, pageLabelRange);
            document.getDocumentCatalog().setPageLabels(pageLabels);
            
            document.save("D:\\SimpleSolution\\DocumentPageLabelsLettersUpper.pdf");
        } catch (IOException e) {
			e.printStackTrace();
		}
    }

}
