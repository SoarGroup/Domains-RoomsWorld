/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package april.lcmtypes;
 
import java.io.*;
import java.nio.*;
import java.util.*;
import lcm.lcm.*;
 
public final class nmea_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public String nmea;
 
    public nmea_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x00c245172bc5521fL;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class>());
    }
 
    public static long _hashRecursive(ArrayList<Class> classes)
    {
        if (classes.contains(april.lcmtypes.nmea_t.class))
            return 0L;
 
        classes.add(april.lcmtypes.nmea_t.class);
        long hash = LCM_FINGERPRINT_BASE
            ;
        classes.remove(classes.size() - 1);
        return (hash<<1) + ((hash>>63)&1);
    }
 
    public void encode(DataOutput outs) throws IOException
    {
        outs.writeLong(LCM_FINGERPRINT);
        _encodeRecursive(outs);
    }
 
    public void _encodeRecursive(DataOutput outs) throws IOException
    {
        char[] __strbuf = null;
        outs.writeLong(this.utime); 
 
        __strbuf = new char[this.nmea.length()]; this.nmea.getChars(0, this.nmea.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
    }
 
    public nmea_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public nmea_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static april.lcmtypes.nmea_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        april.lcmtypes.nmea_t o = new april.lcmtypes.nmea_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        this.utime = ins.readLong();
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.nmea = new String(__strbuf);
 
    }
 
    public april.lcmtypes.nmea_t copy()
    {
        april.lcmtypes.nmea_t outobj = new april.lcmtypes.nmea_t();
        outobj.utime = this.utime;
 
        outobj.nmea = this.nmea;
 
        return outobj;
    }
 
}

