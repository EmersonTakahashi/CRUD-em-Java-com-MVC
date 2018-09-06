package controller;

import bean.LivrosBean;
import interfaces.Interface;
import java.sql.ResultSet;
import model.LivrosDAO;
import utilitarios.Conexao;

public class LivrosController implements Interface {

    LivrosDAO ld = null;

    public LivrosController(LivrosBean lb) {

        this.ld = new LivrosDAO(Conexao.abrirConexao(), lb);
    }
    
    @Override
    public ResultSet carregarDados(Object codigo){
        
        
       return this.ld.carregarDados(codigo);
        
    }
      
    @Override
    public ResultSet filtrar(){
        
        return this.ld.filtrar();
        
    }

    @Override
    public void inserirDados() {
        
        this.ld.inserirDados();       
    }
 
    @Override
    public ResultSet consultarDados() {
        
        return this.ld.consultarDados();  
        
    }

    @Override
    public void excluirDados(int codigo) {
        
        this.ld.excluirDados(codigo);  
    }     

    @Override
    public void alterarDados() {
        this.ld.alterarDados();
    }
}
