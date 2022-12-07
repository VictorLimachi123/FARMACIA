
package com.emergentes.DAO;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {

        try {
            this.conectar();
           String sql = "INSERT INTO productos (nombre,descripcion,vencimiento,stock,categoria_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDate(3, producto.getVencimiento());
            ps.setString(4, producto.getStock());
            ps.setInt(5, producto.getCategoria_id());
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }           
    }

    @Override
    public void update(Producto producto) throws Exception {
         
        try {
            this.conectar();
            String sql = "UPDATE productos SET nombre = ? , descripcion = ? , vencimiento = ? ,stock = ? ,categoria_id = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDate(3, producto.getVencimiento());
            ps.setString(4, producto.getStock());
            ps.setInt(5, producto.getCategoria_id());
            ps.setInt(6,producto.getId());
            
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
           String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
          
            ps.setInt(1,id);
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        } 
    }

    @Override
    public Producto getById(int id) throws Exception {

                Producto pro = new Producto();
        
           try {
            this.conectar();
           

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM productos WHERE id = ? ");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
               if (rs.next()) {
                   
                   pro.setId(rs.getInt("id"));
                   pro.setNombre(rs.getString("nombre"));
                   pro.setDescripcion(rs.getString("descripcion"));
                   pro.setVencimiento(rs.getDate("vencimiento"));
                   pro.setStock(rs.getString("stock"));
                   pro.setCategoria_id(rs.getInt("categoria_id"));
               }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }  
        return pro;       
        
    }

    @Override
    public List<Producto> getAll() throws Exception {

        
         List<Producto> lista  = null;
        
           try {
            this.conectar();
            //String sql ="SELECT * FROM productos";
            //  String sql = "SELECT s.*,p.nombre as producto  FROM categorias s LEFT JOIN productos p ON s.producto_id = p.id";
              String sql = "SELECT s.*,p.nombre as categoria  FROM productos s LEFT JOIN categorias p ON s.categoria_id = p.id";
            
           ///String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
          
             ResultSet rs = ps.executeQuery();
             ////inicial la instanciacion
             lista = new ArrayList<Producto>();
             
               while (rs.next()) {
                     
                   
                   Producto p =new Producto();
                   
                   p.setId(rs.getInt("id"));
                   p.setNombre(rs.getString("nombre"));
                   p.setDescripcion(rs.getString("descripcion"));
                   p.setVencimiento(rs.getDate("vencimiento"));
                   p.setStock(rs.getString("stock"));
                   p.setCategoria_id(rs.getInt("categoria_id"));           
                    p.setCategoria(rs.getString("categoria"));
                   lista.add(p);
                   
                   
               }
               
               rs.close();
               ps.close();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }  
        return lista;
        
  

    }
    
}
