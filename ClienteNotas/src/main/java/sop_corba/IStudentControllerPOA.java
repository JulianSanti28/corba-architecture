package sop_corba;


/**
* sop_corba/IStudentControllerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 11:58:25 AM COT
*/

public abstract class IStudentControllerPOA extends org.omg.PortableServer.Servant
 implements sop_corba.IStudentControllerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("findAllStudent", new java.lang.Integer (0));
    _methods.put ("registrarNota", new java.lang.Integer (1));
    _methods.put ("findStudentById", new java.lang.Integer (2));
    _methods.put ("generarInforme", new java.lang.Integer (3));
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
       case 0:  // sop_corba/IStudentController/findAllStudent
       {
         sop_corba.IStudentControllerPackage.StudentDTO $result[] = null;
         $result = this.findAllStudent ();
         out = $rh.createReply();
         sop_corba.IStudentControllerPackage.LstStudentHelper.write (out, $result);
         break;
       }

       case 1:  // sop_corba/IStudentController/registrarNota
       {
         sop_corba.IStudentControllerPackage.StudentDTO save = sop_corba.IStudentControllerPackage.StudentDTOHelper.read (in);
         boolean $result = false;
         $result = this.registrarNota (save);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // sop_corba/IStudentController/findStudentById
       {
         int id = in.read_long ();
         sop_corba.IStudentControllerPackage.StudentDTO $result = null;
         $result = this.findStudentById (id);
         out = $rh.createReply();
         sop_corba.IStudentControllerPackage.StudentDTOHelper.write (out, $result);
         break;
       }

       case 3:  // sop_corba/IStudentController/generarInforme
       {
         sop_corba.IStudentControllerPackage.InformeDTO $result = null;
         $result = this.generarInforme ();
         out = $rh.createReply();
         sop_corba.IStudentControllerPackage.InformeDTOHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/IStudentController:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IStudentController _this() 
  {
    return IStudentControllerHelper.narrow(
    super._this_object());
  }

  public IStudentController _this(org.omg.CORBA.ORB orb) 
  {
    return IStudentControllerHelper.narrow(
    super._this_object(orb));
  }


} // class IStudentControllerPOA
