package br.com.faculdade.imepac.data_utility;

public class Mask {

    /**
     * Remove espaços em branco do início e do final da string e converte todos os caracteres para maiúsculas.
     * Em seguida, remove todos os caracteres que não sejam letras (A-Z, a-z).
     *
     * @param nome O nome a ser formatado.
     * @return O nome formatado sem espaços, em maiúsculas e apenas com letras.
     */
    public static String mascaraNome(String nome) {
        // Remove espaços em branco do início e do final da string e converte todos os caracteres para maiúsculas
        var nomeSemEspacosNoInicioENoFim = nome.strip().toUpperCase();
        // Remove todos os caracteres que não sejam letras (A-Z, a-z, " ")
        return nomeSemEspacosNoInicioENoFim.replaceAll("[^a-zA-Z ]", "");
    }

    /**
     * Aplica uma máscara ao CPF fornecido.
     *
     * @param cpf O número do CPF a ser formatado com a máscara.
     * @return O CPF formatado com a máscara aplicada.
     */
    public static String mascaraCpf(String cpf) {
        StringBuilder cpfFormatter = new StringBuilder(cpf);
        cpfFormatter.insert(3, ".");
        cpfFormatter.insert(7, ".");
        cpfFormatter.insert(11, "-");
        return String.valueOf(cpfFormatter);
    }

    /**
     * Formata um CEP adicionando a máscara padrão (#####-###).
     *
     * @param cep O CEP a ser formatado.
     * @return O CEP formatado com a máscara padrão (#####-###).
     */
    public static String mascaraCep(String cep) {
        var cepFormatter = new StringBuilder(cep);
        cepFormatter.insert(5, "-");
        return String.valueOf(cepFormatter);
    }

    /**
     * Formata um número de celular adicionando a máscara padrão ((XX) 9XXXX-XXXX).
     *
     * @param numeroCelular O número de celular a ser formatado.
     * @return O número de celular formatado com a máscara padrão ((XX) 9XXXX-XXXX).
     */
    public static String mascaraNumeroCelular(String numeroCelular) {
        //991841164
        var numeroCelularFormatter = new StringBuilder(numeroCelular);
        numeroCelularFormatter.insert(0, "(");
        numeroCelularFormatter.insert(3, ")");
        numeroCelularFormatter.insert(4, " ");
        numeroCelularFormatter.insert(10, "-");
        return String.valueOf(numeroCelularFormatter);
    }
}
