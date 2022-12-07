
package com.emergentes.DAO;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO {

    @Override
    public void insert(Usuario usr) throws Exception {

               try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (nombres,apellidos,correo,password) VALUES (?,?,?,?)");//md5(?)
            
            ps.setString(1,usr.getNombres());
            ps.setString(2,usr.getApellidos()); 
            ps.setString(3, usr.getCorreo()); 
            ps.setString(4, usr.getPassword());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        


    }

    @Override
    public void update(Usuario usr) throws Exception {
          
           try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET nombres = ? , apellidos = ?, correo= ?, password = ? WHERE id = ? ");//password=md5(?)
            ps.setString(1, usr.getNombres());
            ps.setString(2, usr.getApellidos());
            ps.setString(3, usr.getCorreo());
            ps.setString(4, usr.getPassword());
            ps.setInt(5, usr.getId());
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

            PreparedStatement ps = this.conn.prepareStatement("DELETE  FROM usuarios WHERE id = ? ");

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
               
        
        

    }

    @Override
    public Usuario getById(int id) throws Exception {

             Usuario usr = new Usuario();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM usuarios WHERE id = ? ");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usr.setId(rs.getInt("id"));
                usr.setNombres(rs.getString("nombres"));
                usr.setApellidos(rs.getString("apellidos"));
                usr.setCorreo(rs.getString("correo"));
                usr.setPassword(rs.getString("password"));
                

            }

        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();

        }
        return usr;
        
        
        
        
        

    }

    @Override
    public List<Usuario> getAll() throws Exception {

   List<Usuario> lista = null;

        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(" SELECT * FROM usuarios  ");

            lista = new ArrayList<Usuario>();

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario usu = new Usuario();

                usu.setId(rs.getInt("id"));
                 usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setCorreo(rs.getString("correo"));
                 usu.setPassword(rs.getString("password"));

                lista.add(usu);

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
