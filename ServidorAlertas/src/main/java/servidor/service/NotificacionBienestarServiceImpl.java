package servidor.service;

import sop_corba_notificacion.INotificationController;
import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;

public class NotificacionBienestarServiceImpl implements Runnable, INotificarBienestarService {

    private NotificationDTO notificacion;
    private INotificationController objRemoto;

    public NotificacionBienestarServiceImpl(INotificationController objRemoto,NotificationDTO noti) {
        this.objRemoto = objRemoto;
        this.notificacion = noti;
    }
    
  
    @Override
    public void run() {
        System.out.println("Enviando notificacion...");
        registrarNotificacion(this.notificacion);
    }
    
    @Override
    public boolean registrarNotificacion(NotificationDTO save) {
        System.out.println("Guardar notificacion "+save.id);
        if(this.objRemoto.registrarNotification(save)) return true;
        System.out.println("No se pudo enviar notificacion ");
        return false;
    }


}
