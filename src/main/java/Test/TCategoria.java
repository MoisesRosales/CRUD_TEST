/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitys.ECategoria;
import Negocio.NCategoria;

/**
 *
 * @author moise
 */
public class TCategoria {
    
    NCategoria nCategoria = new NCategoria();
    ECategoria categoria = new ECategoria();
    String mensaje = "";
    
    public void add(){
        categoria.setCATEGORY_NAME("NOMBRE_TEST");
        categoria.setDESCRIPTION("DESCRIPTION_TEST");
        categoria.setPICTURE("PICTURE_TEST");
        mensaje = nCategoria.addCategoria(categoria);
        
        System.out.println(mensaje);
    }
    public void update(){
        categoria.setCATEGORY_ID(21);
        categoria.setCATEGORY_NAME("NOMBRE_TEST2");
        categoria.setDESCRIPTION("DESCRIPTION_TEST2");
        categoria.setPICTURE("PICTURE_TEST2");
        mensaje = nCategoria.updateCategoria(categoria);
        
        System.out.println(mensaje);
    }
    public void delete(){
        mensaje = nCategoria.deleteCategoria(21);
        
        System.out.println(mensaje);
    }
    public static void main(String[] args) {
        TCategoria test = new TCategoria();
        //test.add();
        //test.update();
        test.delete();
    }
}
