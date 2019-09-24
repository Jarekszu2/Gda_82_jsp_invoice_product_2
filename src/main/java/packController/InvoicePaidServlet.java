package packController;

import packModel.Invoice;
import packServices.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/invoice-paid")
public class InvoicePaidServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram invoiceId jako rezultat wybrania pozycji: Paid invoice, czyli href: /invoice-paid w invoice-list.jsp
        Long longInvoiceId = Long.parseLong(req.getParameter("invoiceId"));
        // wyszukuję z bazy danych invoice o wybranym id
        Optional<Invoice> optionalInvoice = invoiceService.getOptionalInvoiceById(longInvoiceId);

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            // ładujemy do /invoice-paid parametry dla invoice
            req.setAttribute("invoiceId", longInvoiceId);
            req.setAttribute("invoiceDateOfCreation", invoice.getDateOfCreation());
            req.setAttribute("clientName", invoice.getClientName());
            req.setAttribute("clientNip", invoice.getClientsNip());
            req.setAttribute("clientAddress", invoice.getClientsAddress());
            req.setAttribute("invoiceDateOfRelease", invoice.getDateOfRelease());

            // ładuję plik (invoice-paid.jsp) i przekierowuję tam req (wysyłam request do jsp)
            req.getRequestDispatcher("/invoice-paid.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ustawiamy polskie znaki
        req.setCharacterEncoding("UTF-8");

        // pobieramy dane z invoice-paid.jsp
        Long invoiceId = Long.parseLong(req.getParameter("invoice_id"));
        LocalDateTime localDateTime = LocalDateTime.parse(req.getParameter("invoice_dateOfRelease"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(req.getParameter("invoice_dateOfCreation"));
        String invoice_clientName = req.getParameter("invoice_clientName");
        int invoice_clientNip = Integer.parseInt(req.getParameter("invoice_clientNip"));
        String invoice_clientAddress = req.getParameter("invoice_clientAddress");
        String stringIsPaid = req.getParameter("invoice_if_paid");
        boolean isPaid = (stringIsPaid != null && req.getParameter("invoice_if_paid").equalsIgnoreCase("on"));
        LocalDateTime dateOfPayment = LocalDateTime.parse(req.getParameter("invoice_date_of_payment"));

        Invoice invoice = new Invoice(invoiceId, localDateTime2, invoice_clientName, isPaid, localDateTime, dateOfPayment, invoice_clientNip, invoice_clientAddress);

        // zapisujemy dane w bazie danych
        invoiceService.saveInvoice(invoice);

        // przekierowujemy się na adres: invoice-list
        resp.sendRedirect("/invoice-list");
    }
}
