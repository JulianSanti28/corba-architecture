package cliente.presentation;

import cliente.utils.UtilidadesRegistroC;
import cliente.view.Menu;
import sop_corba.IStudentController;

public class Main {

    public static  void main (String args[]){

        IStudentController objRemoto;
        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";
        objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS,"idObjetoRemoto");
        Menu myMenu = new Menu(objRemoto);
        myMenu.mostrarMenu();
    }
}
