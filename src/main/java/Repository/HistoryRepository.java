package Repository;

import Model.AddressModel;
import Model.HistoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryModel, Long> {
    @Override
    Page<HistoryModel> findAll(Pageable pageable);
}
