package packServices;


import packDatabse.EntityDao;
import packModel.Invoice;

import java.util.List;

public class InvoiceService {
    private EntityDao entityDao = new EntityDao();

    public InvoiceService() {

    }

    public List<Invoice> findAll() {
        return entityDao.getAll(Invoice.class);
    }

    public void addInvoice(String invoice_clientName, int invoice_clientNip, String invoice_clientAddress) {
        entityDao.saveOrUpdate(new Invoice(invoice_clientName, invoice_clientNip, invoice_clientAddress));
    }

//    public void ccc(Invoice invoice) {
//        invoice.
//    }
}
