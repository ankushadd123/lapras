package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class CompanyNameFormat extends Paragraph {

    public CompanyNameFormat(String text){
        super();
        Font font = new Font();
        font.setSize(15);
        font.setStyle(Font.BOLD);
        this.setFont(font);
        this.add(text);
    }
}
