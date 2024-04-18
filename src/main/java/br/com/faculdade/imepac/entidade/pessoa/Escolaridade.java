package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

public enum Escolaridade {

    FUNDAMENTAL,
    MEDIO,
    SUPERIOR,
    POS_GRADUACAO,
    MESTRADO,
    DOUTORADO;
}
