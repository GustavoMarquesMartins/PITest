package br.com.faculdade.imepac.infraestrutura;

public class Mask {
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
     * Aplica uma máscara ao RG fornecido.
     *
     * @param rg O número do RG a ser formatado com a máscara.
     * @return O RG formatado com a máscara aplicada.
     */
    public static String mascaraRg(String rg) {
        StringBuilder rgFormatter = new StringBuilder(rg);
        rgFormatter.insert(rg.length() - 2, "-");
        return String.valueOf(rgFormatter);
    }

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
        // Remove todos os caracteres que não sejam letras (A-Z, a-z)
        return nomeSemEspacosNoInicioENoFim.replaceAll("[^a-zA-Z]", "");
    }
}
