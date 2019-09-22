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

@WebServlet("/invoice-edit")
public class InvoiceEditServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram invoiceId jako rezultat wybrania pozycji: Edit invoice, czyli href: /invoice-edit w invoice-list.jsp
        Long longInvoiceId = Long.parseLong(req.getParameter("invoiceId"));
        // wyszukuję z bazy danych invoice o wybranym id
        Optional<Invoice> optionalInvoice = invoiceService.getOptionalInvoiceById(longInvoiceId);

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            // ładujemy do /invoice-edit parametry dla invoice
            req.setAttribute("invoiceId", invoice.getId());
            req.setAttribute("invoiceDateOfCreation", invoice.getDateOfCreation());
            req.setAttribute("clientName", invoice.getClientName());
            req.setAttribute("clientNip", invoice.getClientsNip());
            req.setAttribute("clientAddress", invoice.getClientsAddress());

            // ładuję plik (invoice-add.jsp) i przekierowuję tam req (wysyłam request do jsp)
            req.getRequestDispatcher("/invoice-add.jsp").forward(req, resp);
        }
//        else {
//            // przekierowujemy na dodawanie (bes edycji)
//            resp.sendRedirect("/invoice-add");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ustawiamy polskie znaki
        req.setCharacterEncoding("UTF-8");

        // pobieramy dane z invoice-add.jsp
        Long invoice_id = Long.parseLong(req.getParameter("invoice_id"));
        LocalDateTime localDateTime = LocalDateTime.parse(req.getParameter("invoice_dateOfCreation"));
        String invoice_clientName = req.getParameter("invoice_clientName");
        int invoice_clientNip = Integer.parseInt(req.getParameter("invoice_clientNip"));
        String invoice_clientAddress = req.getParameter("invoice_clientAddress");

        // zapisujemy dane do bazy danych
        invoiceService.updateInvoice(invoice_id, localDateTime, invoice_clientName, invoice_clientNip, invoice_clientAddress);

        // przekierowujemy się na adres: student-list
        resp.sendRedirect("/invoice-list");
    }
}
