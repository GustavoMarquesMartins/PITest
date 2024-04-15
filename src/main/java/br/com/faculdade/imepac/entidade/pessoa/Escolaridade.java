package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

public enum Escolaridade {

    FUNDAMENTAL,
    MÉDIO,
    SUPERIOR,
    PÓS_GRADUAÇÃO,
    MESTRADO,
    DOUTORADO;
}
