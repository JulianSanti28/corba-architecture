package sop_corba.IStudentControllerPackage;


/**
* sop_corba/IStudentControllerPackage/InformeDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 11:58:25 AM COT
*/

abstract public class InformeDTOHelper
{
  private static String  _id = "IDL:sop_corba/IStudentController/InformeDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.IStudentControllerPackage.InformeDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.IStudentControllerPackage.InformeDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "alertasRojas",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_array_tc (3, _tcOf_members0 );
          _members0[1] = new org.omg.CORBA.StructMember (
            "estudiantesBienestar",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_array_tc (3, _tcOf_members0 );
          _members0[2] = new org.omg.CORBA.StructMember (
            "alertaVerdeCorte",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.IStudentControllerPackage.InformeDTOHelper.id (), "InformeDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.IStudentControllerPackage.InformeDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.IStudentControllerPackage.InformeDTO value = new sop_corba.IStudentControllerPackage.InformeDTO ();
    value.alertasRojas = istream.read_long ();
    value.estudiantesBienestar = new int[3];
    for (int _o0 = 0;_o0 < (3); ++_o0)
    {
      value.estudiantesBienestar[_o0] = istream.read_long ();
    }
    value.alertaVerdeCorte = new int[3];
    for (int _o1 = 0;_o1 < (3); ++_o1)
    {
      value.alertaVerdeCorte[_o1] = istream.read_long ();
    }
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.IStudentControllerPackage.InformeDTO value)
  {
    ostream.write_long (value.alertasRojas);
    if (value.estudiantesBienestar.length != (3))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    for (int _i0 = 0;_i0 < (3); ++_i0)
    {
      ostream.write_long (value.estudiantesBienestar[_i0]);
    }
    if (value.alertaVerdeCorte.length != (3))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    for (int _i1 = 0;_i1 < (3); ++_i1)
    {
      ostream.write_long (value.alertaVerdeCorte[_i1]);
    }
  }

}
