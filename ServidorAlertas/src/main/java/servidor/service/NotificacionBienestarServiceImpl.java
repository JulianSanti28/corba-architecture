package servidor.service;

public class NotificacionBienestarServiceImpl implements Runnable, INotificarBienestarService {

    @Override
    public void run() {
        registrarNotificacion();
    }
    @Override
    public boolean registrarNotificacion() {
        //TO DO
        System.out.println("Enviando notificación...");
        return false;
    }


}
