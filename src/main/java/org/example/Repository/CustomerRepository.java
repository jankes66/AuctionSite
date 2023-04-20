package org.example.Repository;

import org.example.Model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    Page<CustomerModel> findAll(Pageable pageable);

    //@Override
    //List<CustomerModel> findAll();
    //List<CustomerModel> findByFirstNameOrderByFirstNameDesc();
}
