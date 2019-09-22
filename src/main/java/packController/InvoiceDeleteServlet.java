package packController;

import packServices.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/invoice-delete")
public class InvoiceDeleteServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram invoiceId jako rezultat wybrania pozycji: Delete invoice, czyli href: /invoice-delete w invoice-list.jsp
        Long longInvoiceId = Long.parseLong(req.getParameter("invoiceId"));
        // usuwam z bazy danych invoice o wskazanym id
        invoiceService.deleteInvoiceByID(longInvoiceId);
        // przekierowuję akcję na: /invoice-list
        resp.sendRedirect("/invoice-list");
    }
}
