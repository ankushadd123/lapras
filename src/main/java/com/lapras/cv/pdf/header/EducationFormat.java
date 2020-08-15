package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class EducationFormat extends Paragraph {

    public EducationFormat(String text){
        super();
        Font font = new Font();
        font.setSize(13);
        this.setAlignment(ALIGN_CENTER);
        this.setFont(font);
        this.add(text);
    }
}
