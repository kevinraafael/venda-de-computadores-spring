package apsoo.dao;

import apsoo.entity.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemVendaDao extends JpaRepository<ItemVenda, UUID> {
    List<ItemVenda> findByVenda_Id(UUID id);
}
