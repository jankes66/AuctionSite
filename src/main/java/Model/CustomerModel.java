package Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "second_email")
    private String secondEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "mainEmail_id")
    private CustomerModel customerModel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customerModel")
    private Set<AddressModel> addressModels = new HashSet<>();
    private Set<ItemModel> itemModels = new HashSet<>();
    private Set<HistoryModel> historyModels = new HashSet<>();


}
