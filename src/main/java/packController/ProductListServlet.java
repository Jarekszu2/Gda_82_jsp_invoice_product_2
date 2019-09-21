package packController;

import packModel.Product;
import packServices.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // wyciągam listę produktów z bazy danych
        List<Product> products = productService.getAllProducts();

        // nadaję nazwę (do pobrania w product-list.jsp) i ustawiam jako request
        req.setAttribute("lista_produktow_z_bazy_danych", products);

        // ładuję plik (product-list.jsp) i przekierowuję tam req (wysyłam request do jsp)
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
