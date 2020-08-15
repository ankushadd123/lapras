package com.lapras.cv.pdf.header;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class IntroductionFormat extends Paragraph {

    public IntroductionFormat(String text, int alignment){
        super();
        Font font = new Font();
        font.setSize(13);
        this.setAlignment(alignment);
        this.setFont(font);
        this.add(text);
    }
}
