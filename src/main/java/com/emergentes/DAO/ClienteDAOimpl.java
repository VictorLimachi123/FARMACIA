
package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
               try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO clientes (nombres,correo,direccion,celular) VALUES (?,?,?,?)");
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getCelular());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }

   
    }

    @Override
    public void update(Cliente cliente) throws Exception {

           try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE clientes SET nombres = ? , correo= ?, direccion = ?  , celular = ? WHERE id = ? ");
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getCelular());
            ps.setInt(5, cliente.getId());
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

            PreparedStatement ps = this.conn.prepareStatement("DELETE  FROM clientes WHERE id = ? ");

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        
        


    }

    @Override
    public Cliente getById(int id) throws Exception {

              Cliente cli = new Cliente();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM clientes WHERE id = ? ");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNombres(rs.getString("nombres"));
                cli.setCorreo(rs.getString("correo"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCelular(rs.getInt("celular"));

            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        return cli;
        
        
        
        
        

    }

    @Override
    public List<Cliente> getAll() throws Exception {
           
               List<Cliente> lista = null;

        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("select * from clientes");

            lista = new ArrayList<Cliente>();

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setId(rs.getInt("id"));
                cli.setNombres(rs.getString("nombres"));
                cli.setCorreo(rs.getString("correo"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCelular(rs.getInt("celular"));
                
                lista.add(cli);

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
