package org.example.Model;

import org.example.Enums.CategoryAddressEnumsGB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "customer_city")
    private String emailAddress;

    @Column(name = "category_address")
    private CategoryAddressEnumsGB categoryAddress;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "customer_nip")
    private String customerNIP;

    @ManyToOne
    @JoinColumn(name = "customerModel_id")
    private CustomerModel customerModel;
}
