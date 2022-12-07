
package com.emergentes.DAO;

import com.emergentes.modelo.Compra;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CompraDAOimpl extends ConexionDB implements CompraDAO {

    @Override
    public void insert(Compra compra) throws Exception {
      
                try {
            this.conectar();
            String sql = "INSERT INTO compras (factura,cantidad,precio,fecha,descripcion,producto_id,proveedor_id) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1,compra.getFactura());
            ps.setInt(2, compra.getCantidad());
            ps.setFloat(3, compra.getPrecio());
            ps.setDate(4, compra.getFecha());
            ps.setString(5, compra.getDescripcion());
            ps.setInt(6, compra.getProducto_id());
            ps.setInt(7, compra.getProveedor_id());

            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }

    }

    @Override
    public void update(Compra compra) throws Exception {
       
               try {
            this.conectar();
            String sql = "UPDATE compras SET factura = ? ,cantidad = ? ,precio = ?,fecha = ? , descripcion = ?, producto_id = ? ,proveedor_id = ?  WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);
             
            ps.setString(1,compra.getFactura());
            ps.setInt(2, compra.getCantidad());
            ps.setFloat(3, compra.getPrecio());
            ps.setDate(4, compra.getFecha());
            ps.setString(5, compra.getDescripcion());
            ps.setInt(6, compra.getProducto_id());
            ps.setInt(7, compra.getProveedor_id());
            ps.setInt(8, compra.getId());
            
       
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
            String sql = "DELETE FROM compras WHERE id = ?";

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
    public Compra getById(int id) throws Exception {
          
                    Compra m = new Compra();
        try {
            this.conectar();
            String sql = "SELECT * FROM  compras WHERE id = ?";

            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setFactura(rs.getString("factura"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setPrecio(rs.getFloat("precio"));
                m.setFecha(rs.getDate("fecha"));
                m.setDescripcion(rs.getString("descripcion"));

                m.setProducto_id(rs.getInt("producto_id"));
                m.setProveedor_id(rs.getInt("proveedor_id"));
                

            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }

        return m;
        
 

    }

    @Override
    public List<Compra> getAll() throws Exception {

           
                List<Compra>  lista = null;
        try {
            this.conectar();
   String sql = "SELECT m.*,p.nombre as producto, c.nombres as proveedor FROM compras m LEFT JOIN productos p ON m.producto_id = p.id LEFT JOIN proveedores c ON m.proveedor_id = c.id";
           
            //String sql = "SELECT m.*,p.nombre as producto, c.nombres as cliente FROM ventas m LEFT JOIN productos p ON m.producto_id = p.id LEFT JOIN clientes c ON m.cliente_id = c.id";

//  sql += "LEFT JOIN productos p ON m.producto_id = p.id";
          //   sql += "LEFT JOIN clientes c ON m.cliente_id = c.id";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            
           ResultSet rs = ps.executeQuery();
           lista = new ArrayList<Compra>();
           
            while(rs.next()) {
                
                Compra m = new Compra();
                
                m.setId(rs.getInt("id"));
                m.setFactura(rs.getString("factura"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setPrecio(rs.getFloat("precio"));
                m.setFecha(rs.getDate("fecha"));
                m.setDescripcion(rs.getString("descripcion"));
                
                m.setProducto_id(rs.getInt("producto_id"));
                m.setProveedor_id(rs.getInt("proveedor_id"));
 
            
                m.setProducto(rs.getString("producto"));
                m.setProveedor(rs.getString("proveedor"));
             lista.add(m);

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
