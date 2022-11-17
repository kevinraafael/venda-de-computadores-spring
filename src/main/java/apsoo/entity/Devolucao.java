package apsoo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;



@Getter
@Setter
@Entity
@Table(name="devolucao")
public class Devolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "item_venda_id")
    private ItemVenda itemVenda;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private String motivo;

    private Date dtDevolucao = new Date();


    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void dataDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public void salvar(){
        // implementar salvar na classe dao
    }
}
