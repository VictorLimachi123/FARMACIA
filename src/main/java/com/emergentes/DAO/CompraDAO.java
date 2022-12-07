
package com.emergentes.DAO;

import com.emergentes.modelo.Compra;
import java.util.List;


public interface CompraDAO {
        
  public void insert(Compra compra) throws Exception;
  public void update(Compra compra) throws Exception;
  public void delete (int id) throws Exception;
  public Compra getById (int id) throws Exception;
  public List<Compra> getAll() throws Exception;
       
}
