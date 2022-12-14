package sop_corba_notificacion;


/**
* sop_corba_notificacion/INotificationControllerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* s?bado 6 de agosto de 2022 06:46:02 PM COT
*/

public abstract class INotificationControllerPOA extends org.omg.PortableServer.Servant
 implements sop_corba_notificacion.INotificationControllerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("findAllNotifications", new java.lang.Integer (0));
    _methods.put ("registrarNotification", new java.lang.Integer (1));
    _methods.put ("findNotificationByStudentId", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba_notificacion/INotificationController/findAllNotifications
       {
         sop_corba_notificacion.INotificationControllerPackage.NotificationDTO $result[] = null;
         $result = this.findAllNotifications ();
         out = $rh.createReply();
         sop_corba_notificacion.INotificationControllerPackage.LstNotificationHelper.write (out, $result);
         break;
       }

       case 1:  // sop_corba_notificacion/INotificationController/registrarNotification
       {
         sop_corba_notificacion.INotificationControllerPackage.NotificationDTO save = sop_corba_notificacion.INotificationControllerPackage.NotificationDTOHelper.read (in);
         boolean $result = false;
         $result = this.registrarNotification (save);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // sop_corba_notificacion/INotificationController/findNotificationByStudentId
       {
         int id = in.read_long ();
         sop_corba_notificacion.INotificationControllerPackage.NotificationDTO $result[] = null;
         $result = this.findNotificationByStudentId (id);
         out = $rh.createReply();
         sop_corba_notificacion.INotificationControllerPackage.LstNotificationHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba_notificacion/INotificationController:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public INotificationController _this() 
  {
    return INotificationControllerHelper.narrow(
    super._this_object());
  }

  public INotificationController _this(org.omg.CORBA.ORB orb) 
  {
    return INotificationControllerHelper.narrow(
    super._this_object(orb));
  }


} // class INotificationControllerPOA
