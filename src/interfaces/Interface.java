
package interfaces;

import java.sql.ResultSet;
import javax.swing.JTable;

public interface Interface {
    
    public void inserirDados();
    public ResultSet consultarDados();
    public void alterarDados();
    public void excluirDados(int codigo);
    public ResultSet carregarDados(Object codigo);
    public ResultSet filtrar();
}
