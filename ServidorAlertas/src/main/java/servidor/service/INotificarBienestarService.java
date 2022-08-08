package servidor.service;

import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;

public interface INotificarBienestarService {
    public boolean registrarNotificacion(NotificationDTO save);
}
