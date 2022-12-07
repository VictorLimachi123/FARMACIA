
package com.emergentes.DAO;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {

        try {
            this.conectar();
            String sql = "INSERT INTO ventas (factura,cantidad,precio,fecha,descripcion,producto_id,cliente_id) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1,venta.getFactura());
            ps.setInt(2, venta.getCantidad());
            ps.setFloat(3, venta.getPrecio());
            ps.setDate(4, venta.getFecha());
            ps.setString(5, venta.getDescripcion());
            ps.setInt(6, venta.getProducto_id());
            ps.setInt(7, venta.getCliente_id());
            
            
            ps.executeUpdate();


        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
    }

    @Override
    public void update(Venta venta) throws Exception {
         
       try {
            this.conectar();
            String sql = "UPDATE ventas SET factura = ? ,cantidad = ? ,precio = ?,fecha = ? , descripcion = ?, producto_id = ? ,cliente_id = ?  WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);
             
            ps.setString(1,venta.getFactura());
            ps.setInt(2, venta.getCantidad());
            ps.setFloat(3, venta.getPrecio());
            ps.setDate(4, venta.getFecha());
            ps.setString(5, venta.getDescripcion());
            ps.setInt(6, venta.getProducto_id());
            ps.setInt(7, venta.getCliente_id());
            ps.setInt(8, venta.getId());
            
            
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
            String sql = "DELETE FROM ventas WHERE id = ?";

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
    public Venta getById(int id) throws Exception {

               Venta v = new Venta();
        try {
            this.conectar();
            String sql = "SELECT * FROM  ventas WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setFactura(rs.getString("factura"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setPrecio(rs.getFloat("precio"));
                v.setFecha(rs.getDate("fecha"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
                

            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }

        return v;
        
        
        

    }

    @Override
    public List<Venta> getAll() throws Exception {
          
        
                List<Venta>  lista = null;
        try {
            this.conectar();
            String sql = "SELECT v.*,p.nombre as producto, c.nombres as cliente FROM ventas v LEFT JOIN productos p ON v.producto_id = p.id LEFT JOIN clientes c ON v.cliente_id = c.id";
           //  sql += "LEFT JOIN productos p ON v.producto_id = p.id";
          //   sql += "LEFT JOIN clientes c ON v.cliente_id = c.id";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
           ResultSet rs = ps.executeQuery();
           lista = new ArrayList<Venta>();
           
            while(rs.next()) {
                
                Venta v = new Venta();
                
                v.setId(rs.getInt("id"));
                v.setFactura(rs.getString("factura"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setPrecio(rs.getFloat("precio"));
                v.setFecha(rs.getDate("fecha"));
                v.setDescripcion(rs.getString("descripcion"));
                
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
 
            
                v.setProducto(rs.getString("producto"));
                v.setCliente(rs.getString("cliente"));
             lista.add(v);

            }
                     rs.close();
                     rs.close();
            
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
           return lista;

    }
      
   
    
    
    
    
    
}
