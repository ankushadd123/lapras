package com.lapras.cv.pdf.format;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.List;

public class AddressHeader extends PdfPTable {

    public AddressHeader(List<PdfPCell> cells, int columns) {
        super(columns);
        this.setWidthPercentage(100);
        if (!cells.isEmpty())
            this.addCell(cells.get(0));
        cells.stream().skip(1).forEach(this::addCell);
    }

}
