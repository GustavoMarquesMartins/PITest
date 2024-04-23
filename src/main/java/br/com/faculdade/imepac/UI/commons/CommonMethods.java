package br.com.faculdade.imepac.UI.commons;

import br.com.faculdade.imepac.UI.cadastro.FormDadosFuncionario;
import java.awt.BorderLayout;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta classe fornece métodos utilitários comuns para interações com
 * componentes de interface de usuário.
 */
public class CommonMethods {

    /**
     * Remove caracteres especiais de uma string.
     *
     * @param originalText A string da qual os caracteres especiais serão
     * removidos.
     * @return A string sem caracteres especiais.
     */
    public static String removeSpecialCharacters(String originalText) {
        if (originalText.isEmpty()) {
            return originalText;
        } else {
            String newString = originalText.replaceAll("[^0-9]", "");
            return newString;
        }
    }

    public static LocalDate parseStringToLocalDate(String dateString) throws Exception {
        String date = CommonMethods.removeSpecialCharacters(dateString);

        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Data é um campo obrigatório!");
        }

        if (date.length() != 8) {
            throw new IllegalArgumentException("Formato de data inválido! Use DD/MM/AAAA");
        }

        int dia = Integer.parseInt(date.substring(0, 2));
        int mes = Integer.parseInt(date.substring(2, 4));
        int ano = Integer.parseInt(date.substring(4, 8));

        try {
            return LocalDate.of(ano, mes, dia);
        } catch (Exception e) {
            throw new IllegalArgumentException("Data inválida! Verifique os valores de dia, mês e ano.");
        }
    }

    /**
     * Método genérico que cria uma instância da classe com argumentos para o
     * construtor.
     *
     * @param tipoDaClasse O tipo da classe a ser instanciada.
     * @param args Os argumentos para o construtor da classe.
     * @return Uma instância da classe especificada.
     * @throws Exception Se ocorrer um erro ao criar a instância.
     */
    public static <T> T criarInstancia(Class<T> tipoDaClasse, Object... args) throws Exception {
        Class<?>[] tiposDosArgs = getTiposDosArgumentos(args);
        Constructor<T> construtor = tipoDaClasse.getDeclaredConstructor(tiposDosArgs);
        return construtor.newInstance(args);
    }

    /**
     * Método auxiliar para obter os tipos dos argumentos.
     *
     * @param args Os argumentos para o construtor.
     * @return Um array de classes representando os tipos dos argumentos.
     */
    private static Class<?>[] getTiposDosArgumentos(Object... args) {
        Class<?>[] tipos = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            tipos[i] = args[i].getClass();
        }
        return tipos;
    }

    /**
     * Método que navega para uma nova página em um JFrame, substituindo o
     * conteúdo atual pelo componente fornecido.
     *
     * @param frame O JFrame onde a nova página será exibida.
     * @param instance O componente JPanel que representa a nova página.
     */
    public static <T extends JPanel> void goToNewPage(JFrame frame, T instance) {
        // Remove o painel atual
        frame.getContentPane().removeAll();

        // Define o layout do JFrame para suportar a adição de componentes
        frame.getContentPane().setLayout(new BorderLayout());

        try {
            // Adiciona o painel ao centro do layout do frame atual
            frame.add(instance, BorderLayout.CENTER);

            // Atualiza o layout do JFrame
            frame.revalidate();
            frame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String dataFormatter(LocalDate data) {
        // Criar um formatador de data para o padrão brasileiro (dd/MM/yyyy)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatar a data
        return data.format(formatador);
    }
}
