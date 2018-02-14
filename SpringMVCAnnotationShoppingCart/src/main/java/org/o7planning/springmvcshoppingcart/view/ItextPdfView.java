package org.o7planning.springmvcshoppingcart.view;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.memorynotfound.model.Course;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
       // List<Course> courses = (List<Course>) model.get("courses");
        CartInfo cartInfo = Utils.getCartInSession(request);
        
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{10, 60, 30});

//        table.addCell(""+cartInfo.getOrderNum());
        table.addCell("Total: "+cartInfo.getAmountTotal());
        table.addCell("Nombre: "+cartInfo.getCustomerInfo().getName());
        table.addCell("Email: "+cartInfo.getCustomerInfo().getEmail());
        table.addCell("Tel�fono: "+cartInfo.getCustomerInfo().getPhone());
//        for (carLineInfo)

//        for (Course course : courses){
//            table.addCell(String.valueOf(course.getId()));
//            table.addCell(course.getName());
//            table.addCell(DATE_FORMAT.format(course.getDate()));
//        }



        document.add(table);
    }

}