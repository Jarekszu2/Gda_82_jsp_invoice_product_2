package packServices;

import packDatabse.EntityDao;
import packModel.Invoice;
import packModel.Product;
import packModel.TaxType;

import java.util.List;

public class ProductService {
    private EntityDao entityDao = new EntityDao();

    public ProductService() {
    }

    public List<Product> getAllProducts() {
        return entityDao.getAll(Product.class);
    }

    public void addProduct(Invoice invoice, String productName, double productPrice, String productTaxType, int productStock) {
        TaxType taxType = TaxType.valueOf(productTaxType);
        Product product = new Product(productName, productPrice, taxType, productStock);
        product.setInvoice(invoice);

        entityDao.saveOrUpdate(product);
    }
}
