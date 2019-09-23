package packController;

import packModel.Invoice;
import packModel.Product;
import packModel.TaxType;
import packServices.InvoiceService;
import packServices.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product-edit")
public class ProductEditServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram id productu (productId) do edycji jako wynik wybrania Edit product w: product-list.jsp
        Long productIdToEdit = Long.parseLong(req.getParameter("productId"));
        // wyciągam z bazy danych product o wybranym id
        Optional<Product> optionalProduct = productService.getProductById(productIdToEdit);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // przekazujemy parametry(wartości pól) obiektu: product, na wejście w: /product-edit.jsp
            req.setAttribute("productId", product.getId());
            req.setAttribute("productName", product.getName());
            req.setAttribute("productPrice", product.getPrice());
            req.setAttribute("productTaxType", product.getTaxType());
            req.setAttribute("productStock", product.getStock());
            req.setAttribute("productInvoiceId", product.getInvoice().getId());

            // ładuję plik (product-edit.jsp) i przekierowuję tam req (wysyłam request do jsp)
            req.getRequestDispatcher("/product-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ustawiamy polskie znaki
        req.setCharacterEncoding("UTF-8");

        // pobieramy dane z product-edit.jsp
        Long invoiceIdAfterProductEdit = Long.parseLong(req.getParameter("invoice_id"));
        Optional<Invoice> optionalInvoice = invoiceService.getOptionalInvoiceById(invoiceIdAfterProductEdit);
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            Long productIdAfterEdit = Long.parseLong(req.getParameter("product_id"));
            String productNameAfterEdit = req.getParameter("product_name");
            double productPriceAfterEdit = Double.parseDouble(req.getParameter("product_price"));
            TaxType productTaxTypeAfterEdit = TaxType.valueOf(req.getParameter("tax_type"));
            int productStockAfterEdit = Integer.parseInt(req.getParameter("product_stock"));

            Product product = new Product(productIdAfterEdit,productNameAfterEdit, productPriceAfterEdit, productTaxTypeAfterEdit, productStockAfterEdit, invoice);

            // zapisujemy zmieniony obiekt w bazie danych
            productService.updateProduct(product);

            // przekierowujemy się na adres: product-list
            resp.sendRedirect("/product-list");
        }

    }
}
