package sop_corba;

/**
* sop_corba/IStudentControllerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 11:58:25 AM COT
*/

public final class IStudentControllerHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.IStudentController value = null;

  public IStudentControllerHolder ()
  {
  }

  public IStudentControllerHolder (sop_corba.IStudentController initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.IStudentControllerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.IStudentControllerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.IStudentControllerHelper.type ();
  }

}
