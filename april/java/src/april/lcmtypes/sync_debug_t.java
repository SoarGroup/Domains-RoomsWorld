/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package april.lcmtypes;
 
import java.io.*;
import java.nio.*;
import java.util.*;
import lcm.lcm.*;
 
public final class sync_debug_t implements lcm.lcm.LCMEncodable
{
    public long rx_utime;
    public long sensor_time;
    public long estimated_utime;
 
    public sync_debug_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xc867cc54e3f80410L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class>());
    }
 
    public static long _hashRecursive(ArrayList<Class> classes)
    {
        if (classes.contains(april.lcmtypes.sync_debug_t.class))
            return 0L;
 
        classes.add(april.lcmtypes.sync_debug_t.class);
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
        outs.writeLong(this.rx_utime); 
 
        outs.writeLong(this.sensor_time); 
 
        outs.writeLong(this.estimated_utime); 
 
    }
 
    public sync_debug_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public sync_debug_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static april.lcmtypes.sync_debug_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        april.lcmtypes.sync_debug_t o = new april.lcmtypes.sync_debug_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.rx_utime = ins.readLong();
 
        this.sensor_time = ins.readLong();
 
        this.estimated_utime = ins.readLong();
 
    }
 
    public april.lcmtypes.sync_debug_t copy()
    {
        april.lcmtypes.sync_debug_t outobj = new april.lcmtypes.sync_debug_t();
        outobj.rx_utime = this.rx_utime;
 
        outobj.sensor_time = this.sensor_time;
 
        outobj.estimated_utime = this.estimated_utime;
 
        return outobj;
    }
 
}

