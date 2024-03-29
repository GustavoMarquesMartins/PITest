package br.com.faculdade.imepac.infraestrutura;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de conversão para persistência de listas de strings em uma única coluna de banco de dados.
 * Esta classe converte uma lista de strings em uma única string separada por um delimitador específico ao persistir no banco de dados,
 * e vice-versa ao recuperar do banco de dados.
 */
public class ListaStringConverter implements AttributeConverter<List<String>, String> {
    private static final String DELIMITADOR = ",";

    /**
     * Converte uma lista de strings em uma única string para ser armazenada no banco de dados.
     * Os elementos da lista são concatenados em uma única string usando um delimitador específico.
     *
     * @param lista A lista de strings a ser convertida.
     * @return Uma única string contendo todos os elementos da lista, separados pelo delimitador.
     */
    @Override
    public String convertToDatabaseColumn(List<String> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return lista.stream().collect(Collectors.joining(DELIMITADOR));
    }

    /**
     * Converte uma string do banco de dados em uma lista de strings.
     * A string é dividida em elementos da lista com base em um delimitador específico.
     *
     * @param string A string armazenada no banco de dados.
     * @return Uma lista de strings contendo os elementos da string dividida pelo delimitador.
     */
    @Override
    public List<String> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return Arrays.asList(string.split(DELIMITADOR));
    }
}
