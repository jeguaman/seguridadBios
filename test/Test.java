
import com.teamj.distribuidas.facade.FacadeNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Guaman
 */
public class Test {

    public static void main(String[] args) {
        try {
            //FacadeNegocio.retrieveTodosUsuariosByPerfil(1);
            FacadeNegocio.retrieveUsuarioXPerfilBy_CodUsuario(6);
            System.out.println("");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
