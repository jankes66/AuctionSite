package org.example.Repository;

import org.example.Model.MainEmailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainEmailRepository extends JpaRepository<MainEmailModel, Long> {
    Page<MainEmailModel> findAll(Pageable pageable);
}
