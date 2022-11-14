package apsoo.computadores.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @OneToOne
    @JoinColumn(name = "computador_id")
    private Computador computador;



    private int qtdVendida ;

    private double valorVendido ;




}