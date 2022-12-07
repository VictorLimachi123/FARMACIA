
package com.emergentes.DAO;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO {

    @Override
    public void insert(Proveedor proveedor) throws Exception {

               try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO proveedores (nombres,correo,direccion,celular) VALUES (?,?,?,?)");
            
            
            ps.setString(1, proveedor.getNombres());
            ps.setString(2, proveedor.getCorreo());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getCelular());
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }

        
        

    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE proveedores SET nombres = ? , correo = ?, direccion = ? , celular = ? WHERE id = ? ");
            ps.setString(1, proveedor.getNombres());
            ps.setString(2, proveedor.getCorreo());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getCelular());
            ps.setInt(5, proveedor.getId());
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

            PreparedStatement ps = this.conn.prepareStatement("DELETE  FROM proveedores WHERE id = ? ");

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        
        
    }

    @Override
    public Proveedor getById(int id) throws Exception {

        //Cliente cli = new Cliente();
        Proveedor pr = new Proveedor();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM proveedores WHERE id = ? ");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                 
                pr.setId(rs.getInt("id"));
                pr.setNombres(rs.getString("nombres"));
                pr.setCorreo(rs.getString("correo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCelular(rs.getInt("celular"));
                
                
                
                
            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        return pr;
        
        
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        
               List<Proveedor> lista = null;

        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM proveedores  ");

            lista = new ArrayList<Proveedor>();

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Proveedor pr = new Proveedor();

               pr.setId(rs.getInt("id"));
                pr.setNombres(rs.getString("nombres"));
                pr.setCorreo(rs.getString("correo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCelular(rs.getInt("celular"));

                lista.add(pr);
                
                
                
                
                

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
