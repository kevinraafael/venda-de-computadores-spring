package apsoo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;


    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "forma_pagamento")
    private Pagamento formaPagemnto;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany
    private List<ItemVenda> itemVendas;

    private int codigo;


    private Double valor;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        String vendaInfo = "Código da Venda: " + getCodigo() + " Valor: R$ " + getValor() + "\n"+
                "\n";
        return vendaInfo;
    }
}
