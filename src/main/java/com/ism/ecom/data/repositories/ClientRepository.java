package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
           List<Client> findAllByActiveTrue();
           Client findClientByTelephoneAndActiveTrue(String telephone);
           Page<Client> findAllByActiveTrue(Pageable pageable);
           Page<Client>   findAllByTelephoneContainsAndActiveTrue(String telephone,Pageable pageable);
           List<Client> findAllByActive(Boolean active);
}
