
package com.emergentes.DAO;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO {

    @Override
    public void insert(Categoria categoria) throws Exception {

                     try {
            this.conectar();
            String sql = "INSERT INTO categorias (nombre,descripcion,tipo) VALUES (?,?,?)";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1,categoria.getNombre());
            ps.setString(2,categoria.getDescripcion());
            ps.setString(3,categoria.getTipo());
        

            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Categoria categoria) throws Exception {
       
               
               try {
            this.conectar();
            String sql = "UPDATE categorias SET nombre = ? , descripcion = ?, tipo = ?   WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);
             
            ps.setString(1,categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
           ps.setString(3, categoria.getTipo());
            ps.setInt(4, categoria.getId());
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

               }
    }

    @Override
    public void delete(int id) throws Exception {

              try {
            this.conectar();
            String sql = "DELETE FROM categorias WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);
   
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public Categoria getById(int id) throws Exception {
      
        
       Categoria s = new Categoria();
        try {
            this.conectar();
            String sql = "SELECT * FROM  categorias WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setDescripcion(rs.getString("descripcion"));             
                s.setTipo(rs.getString("tipo"));
            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return s;

    }

    @Override
    public List<Categoria> getAll() throws Exception {

            List<Categoria>  lista = null;
        try {
            this.conectar();
              String sql ="SELECT * FROM categorias";
           
            //String sql = "SELECT s.*,p.nombre as producto, c.nombres as cliente FROM ventas s LEFT JOIN productos p ON s.producto_id = p.id LEFT JOIN clientes c ON s.cliente_id = c.id";

//  sql += "LEFT JOIN productos p ON s.producto_id = p.id";
          //   sql += "LEFT JOIN clientes c ON s.cliente_id = c.id";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
           ResultSet rs = ps.executeQuery();
           lista = new ArrayList<Categoria>();
           
            while(rs.next()) {
                
                Categoria s = new Categoria();
                
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setTipo(rs.getString("tipo"));
             lista.add(s);
            }
                     rs.close();
            
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
           return lista;
           
     

    }
    
}
