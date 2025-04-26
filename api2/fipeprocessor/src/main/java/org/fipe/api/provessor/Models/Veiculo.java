package org.fipe.api.provessor.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Veiculo extends PanacheEntityBase {

    @Id
    public String codigo;
    public String marca;
    public String modelo;
    public String observacoes;
}
