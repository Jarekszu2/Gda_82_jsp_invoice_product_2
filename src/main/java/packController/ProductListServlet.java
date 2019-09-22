package packController;

import packModel.Invoice;
import packModel.Product;
import packServices.InvoiceService;
import packServices.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("invoiceId") != null) {// listuję producty dla konkretnego invoice
            // pobieram invoiceId jako rezultat wybrania pozycji: List products, czyli href: /product-list w invoice-list.jsp
            Long longInvoiceId = Long.parseLong(req.getParameter("invoiceId"));
            Optional<Invoice> invoiceOptional = invoiceService.getOptionalInvoiceById(longInvoiceId);

            if (invoiceOptional.isPresent()) {
                Invoice invoice = invoiceOptional.get();
                List<Product> productList = invoice.getProducts();
                req.setAttribute("lista_produktow_z_bazy_danych", productList);
                req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
            }
        } else { // listuję wszystkie produkty
            // wyciągam listę produktów z bazy danych
            List<Product> products = productService.getAllProducts();

            // nadaję nazwę (do pobrania w product-list.jsp) i ustawiam jako request
            req.setAttribute("lista_produktow_z_bazy_danych", products);

            // ładuję plik (product-list.jsp) i przekierowuję tam req (wysyłam request do jsp)
            req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
        }
    }
}
