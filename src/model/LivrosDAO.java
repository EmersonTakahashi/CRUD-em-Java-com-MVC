
package model;

import bean.LivrosBean;
import interfaces.Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LivrosDAO implements Interface{
    
    Connection con = null;
    LivrosBean lb = null;
    ResultSet rs = null;           
    
    public LivrosDAO(Connection con, LivrosBean lb){
        
        this.con = con;
        this.lb = lb;
        
    }
    
    @Override
    public void inserirDados(){
        
        try{
            
            String sql = "insert into tbl_livros (titulo, autor, editora, dataLancamento) values (?, ?, ?, ?)";
            PreparedStatement ps = this.con.prepareStatement(sql);

            ps.setString(1, lb.getTitulo());
            ps.setString(2, lb.getAutor());
            ps.setString(3, lb.getEditora());
            ps.setString(4, lb.getDataLancamento());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
                        
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
                
    }
    
    @Override
    public void excluirDados(int codigo){
        
        try{
            
            String sql = "delete from tbl_livros where cod_livros = ?";
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro excluido com sucesso!");
                        
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        
    }        
    
    @Override
    public ResultSet consultarDados(){
        try{
                        
            String sql = "select * from tbl_livros";
            PreparedStatement ps = con.prepareStatement(sql);            
            rs = ps.executeQuery();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            
        } 
        
       return rs; 
    }
    
        
    @Override
    public ResultSet carregarDados(Object codigo){
        try{
            
            String sql = "select * from tbl_livros where cod_livros = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setObject(1, codigo);
            rs = ps.executeQuery();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            
        } 
        
       return rs; 
    }  
    
    @Override
    public void alterarDados(){
        
        try{
            
            String sql = "update tbl_livros set titulo = ?, autor = ?, editora = ?, dataLancamento = ? where cod_livros = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, lb.getTitulo());
            ps.setString(2, lb.getAutor());
            ps.setString(3, lb.getEditora());
            ps.setString(4, lb.getDataLancamento());            
            ps.setInt(5, lb.getCodLivros());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            
        } 
        
    }
    
    @Override
    public ResultSet filtrar(){
        try{
            
            String sql = "select * from tbl_livros where titulo like ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, lb.getTitulo() + "%");
            rs = ps.executeQuery();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        
        }catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            
        } 
        
       return rs;         
    }
    
}
