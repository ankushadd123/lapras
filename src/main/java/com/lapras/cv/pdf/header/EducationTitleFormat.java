package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class EducationTitleFormat extends Paragraph {

    public EducationTitleFormat(String text){
        super();
        Font font = new Font();
        font.setSize(13);
        font.setStyle(Font.BOLD);
        this.setAlignment(ALIGN_CENTER);
        this.setFont(font);
        this.add(text);
    }
}
