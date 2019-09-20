package packController;

import packServices.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/invoice-add")
public class InvoiceAddServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // załaduj plik jsp i przekieruj tam req (parametry i resp) // wyślij request do ...jsp
        req.getRequestDispatcher("/invoice-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ustawiamy polskie znaki
        req.setCharacterEncoding("UTF-8");

        // pobieramy dane z invoice-add.jsp
        String invoice_clientName = req.getParameter("invoice_clientName");
        int invoice_clientNip = Integer.parseInt(req.getParameter("invoice_clientNip"));
        String invoice_clientAddress = req.getParameter("invoice_clientAddress");

        // zapisujemy dane do bazy danych
        invoiceService.addInvoice(invoice_clientName, invoice_clientNip, invoice_clientAddress);

        // przekierowujemy się na adres: student-list
        resp.sendRedirect("/invoice-list");
    }
}
