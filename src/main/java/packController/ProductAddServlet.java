package packController;

import packModel.Invoice;
import packServices.InvoiceService;
import packServices.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product-add")
public class ProductAddServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram invoiceId jako rezultat wybrania pozycji: Add product, czyli href: /product-add w invoice-list.jsp
        Long longInvoiceId = Long.parseLong(req.getParameter("invoiceId"));
        // nadaję nazwę (do pobrania w product-add.jsp) i ustawiam jako request
        req.setAttribute("invoice_choosen_from_list", longInvoiceId);
        // ładuję plik (product-add.jsp) i przekierowuję tam req (wysyłam request do jsp)
        req.getRequestDispatcher("/product-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ustawiamy polskie znaki
        req.setCharacterEncoding("UTF-8");

        Long invoiceIdentifier = Long.parseLong(req.getParameter("invoice_to_whom_i_sholud_give_product_to"));
        Optional<Invoice> invoiceOptional = invoiceService.getOptionalInvoiceById(invoiceIdentifier);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();

            // wyciągamy dane z product-add.jsp
            String productName = req.getParameter("product_name");
            int productPrice = Integer.parseInt(req.getParameter("product_price"));
            String productTaxType = req.getParameter("tax_type");
            int productStock = Integer.parseInt(req.getParameter("product_stock"));

            // zapisujemy dane do bazy danych
            productService.addProduct(invoice, productName, productPrice, productTaxType, productStock);

            // przekierowujemy się na adres: invoice-list
            resp.sendRedirect("/invoice-list");
        }
    }
}
