/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.prendas.dao;

import java.util.List;
import mx.edu.utng.prendas.model.Prenda;

/**
 *
 * @author Sofia 
 */
public interface PrendaDAO {
    void agregarPrenda(Prenda prenda);
    void borrarPrenda(int idPrenda);
    void cambiarPrenda(Prenda prenda);
    List<Prenda> desplegarPrenda();
    Prenda elegirPrenda(int idPrenda);

}
