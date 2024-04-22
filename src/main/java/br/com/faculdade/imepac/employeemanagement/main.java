package br.com.faculdade.imepac.employeemanagement;

import br.com.faculdade.imepac.UI.cadastro.FormDadosFuncionario;
import br.com.faculdade.imepac.UI.cadastro.PaginaInicial;
import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.*;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Esta é a classe principal (main) que inicia o aplicativo de gerenciamento de
 * funcionários. O aplicativo é executado em uma interface gráfica Swing.
 */
public class main {

    /**
     * Método principal que inicializa o aplicativo.
     *
     * @param args Os argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Executa o aplicativo Swing na Event Dispatch Thread (EDT) para garantir a segurança da interface do usuário
        SwingUtilities.invokeLater(() -> {
            PaginaInicial.main(args);
        });
    }
}
