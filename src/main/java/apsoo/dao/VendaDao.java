package apsoo.dao;

import apsoo.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaDao extends JpaRepository<Venda, UUID> {


}
