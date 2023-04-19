package Model;

import Enums.ItemCategoryEnumGB;
import Enums.ItemConditionEnumGB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Element;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_category")
    private ItemCategoryEnumGB itemCategory;

    @Column(name = "item_photo")
    private Set<Element> itemPhoto;

    @Column(name = "item_condition")
    private ItemConditionEnumGB itemCondition;

    @Column(name = "item_price")
    private float itemPrice;

    @Column(name = "number_of_item")
    private int numberOfItem;

    @ManyToOne
    @JoinColumn(name = "customerModel_id")
    private ItemModel itemModel;
}
