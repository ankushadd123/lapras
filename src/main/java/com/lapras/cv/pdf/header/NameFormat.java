package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class NameFormat extends Paragraph {

    public NameFormat(String text){
        super();
        Font font = new Font();
        font.setSize(17);
        font.setStyle(Font.BOLD);
        this.setFont(font);
        this.add(text);
    }
}
