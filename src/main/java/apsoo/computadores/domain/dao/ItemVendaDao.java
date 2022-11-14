package apsoo.computadores.domain.dao;

import apsoo.computadores.domain.entity.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemVendaDao extends JpaRepository<ItemVenda, UUID> {
}
