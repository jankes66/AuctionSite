package Repository;

import Model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AddressModel a SET a.categoryAddress = :categoryAddress WHERE a.id = :id")
    //int updateCategoryAddressById(@Param(("id") Long id, @Param("categoryAddress") String categoryAddress);

    @Override
    List<AddressModel> findAll();

    List<AddressModel> findByCategoryAddress(String category);
}
