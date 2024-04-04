
package br.com.faculdade.imepac.entidade.pessoa;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "habilidades")
@Data
@NoArgsConstructor
public class Habilidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String habilidade;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    
}
