package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class ProjectNameFormat extends Paragraph {

    public ProjectNameFormat(String text){
        super();
        Font font = new Font();
        font.setSize(13);
        font.setStyle(Font.BOLD);
        this.setFont(font);
        this.add(text);
    }
}
