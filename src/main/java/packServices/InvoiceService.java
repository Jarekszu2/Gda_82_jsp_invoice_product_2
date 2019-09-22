package packServices;


import packDatabse.EntityDao;
import packModel.Invoice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public void updateInvoice(Long invoice_id, LocalDateTime invoice_dateOfCreation, String invoice_clientName, int invoice_clientNip, String invoice_clientAddress) {
        entityDao.saveOrUpdate(new Invoice(invoice_id, invoice_dateOfCreation, invoice_clientName, invoice_clientNip, invoice_clientAddress));
    }

    public Optional<Invoice> getOptionalInvoiceById(Long invoiceId) {
        return entityDao.getById(Invoice.class, invoiceId);
    }

    public void deleteInvoiceByID(Long invoiceId) {
        entityDao.delete(Invoice.class, invoiceId);
    }
}
