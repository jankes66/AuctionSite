package Repository;

import Model.AddressModel;
import Model.ItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {

    @Override
    Page<ItemModel> findAll(Pageable pageable);
}
