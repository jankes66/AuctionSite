package Repository;

import Model.MainEmailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainEmailRepository extends JpaRepository<MainEmailModel, Long> {
    Page<MainEmailModel> findAll(Pageable pageable);
}
