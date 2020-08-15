package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class ToolsTechnologiesTitleFormat extends Paragraph {

    public ToolsTechnologiesTitleFormat(String text){
        super();
        Font font = new Font();
        font.setSize(13);
        this.setAlignment(ALIGN_RIGHT);
        this.setFont(font);
        this.add(text);
    }
}
