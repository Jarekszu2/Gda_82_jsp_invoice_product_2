package packController;

import packServices.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product-delete")
public class ProductDeleteServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobieram id productu do usunięcia(productId) z: product-list.jsp dla opcji: Delete product
        Long productIdToDelete = Long.parseLong(req.getParameter("productId"));

        // usuwam product o wybranym id z bazy danych
        productService.deleteProduct(productIdToDelete);

        // przekierowuję akcję na: /product-list
        resp.sendRedirect("product-list");
    }
}
