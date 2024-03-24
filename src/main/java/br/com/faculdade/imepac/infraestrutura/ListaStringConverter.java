package br.com.faculdade.imepac.infraestrutura;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListaStringConverter implements AttributeConverter<List<String>, String> {
    private static final String DELIMITADOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> lista) {
        if (lista == null || lista.isEmpty()){
            return null;
        }
        return lista.stream().collect(Collectors.joining(DELIMITADOR));
    }
    @Override
    public List<String> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return Arrays.asList(string.split(DELIMITADOR));
    }
}
