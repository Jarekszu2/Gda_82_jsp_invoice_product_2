package packController;

import packModel.Invoice;
import packServices.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/invoice-list")
public class InvoiceListServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // wyciągam listę z bazy danych
        List<Invoice> list = invoiceService.findAll();

        // nadaję nazwę (do pobrania w invoice-list.jsp) i ustawiam jako request
        req.setAttribute("lista_invoices_z_bazy_danych", list);

        // ładuję plik (invoice-list.jsp) i przekierowuję tam req (wysyłam request do jsp)
        req.getRequestDispatcher("/invoice-list.jsp").forward(req, resp);
    }
}
