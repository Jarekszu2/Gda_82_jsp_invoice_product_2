package packModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice implements IbaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private LocalDateTime dateOfCreation;
    @Column(nullable = false)
    private String clientName;
    @Column(nullable = false, columnDefinition = " tinyint default 0")
    private boolean ifPaid;
    private LocalDateTime dateOfRelease;
    private LocalDateTime dateOfPayment;
    @Formula(value = "(SELECT SUM(p.price * p.stock) from product p where p.invoice_id = id)")
    private Double billValue;
//    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE})
    private List<Product> products;
    @Column(nullable = false, length = 10)
    private int clientsNip;
    @Column(nullable = false)
    private String clientsAddress;

    public Invoice(String clientName, int clientsNip, String clientsAddress) {
        this.clientName = clientName;
        this.clientsNip = clientsNip;
        this.clientsAddress = clientsAddress;
    }

    public Invoice(Long id, LocalDateTime dateOfCreation, String clientName, boolean ifPaid, LocalDateTime dateOfRelease, LocalDateTime dateOfPayment, int clientsNip, String clientsAddress) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.clientName = clientName;
        this.ifPaid = ifPaid;
        this.dateOfRelease = dateOfRelease;
        this.dateOfPayment = dateOfPayment;
        this.clientsNip = clientsNip;
        this.clientsAddress = clientsAddress;
    }

    public Invoice(Long id, LocalDateTime dateOfRelease) {
        this.id = id;
        this.dateOfRelease = dateOfRelease;
    }

    public Invoice(Long id, LocalDateTime dateOfCreation, String clientName, int clientsNip, String clientsAddress) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.clientName = clientName;
        this.clientsNip = clientsNip;
        this.clientsAddress = clientsAddress;
    }

    public Invoice(Long id, LocalDateTime dateOfCreation, String clientName, int clientsNip, String clientsAddress, LocalDateTime dateOfRelease) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.clientName = clientName;
        this.clientsNip = clientsNip;
        this.clientsAddress = clientsAddress;
        this.dateOfRelease = dateOfRelease;
    }
}