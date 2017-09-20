/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package april.lcmtypes;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class laser_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public int nranges;
    public float ranges[];
    public int nintensities;
    public float intensities[];
    public float rad0;
    public float radstep;
 
    public laser_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xf1e8ba118c05af46L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(april.lcmtypes.laser_t.class))
            return 0L;
 
        classes.add(april.lcmtypes.laser_t.class);
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
        outs.writeLong(this.utime); 
 
        outs.writeInt(this.nranges); 
 
        for (int a = 0; a < this.nranges; a++) {
            outs.writeFloat(this.ranges[a]); 
        }
 
        outs.writeInt(this.nintensities); 
 
        for (int a = 0; a < this.nintensities; a++) {
            outs.writeFloat(this.intensities[a]); 
        }
 
        outs.writeFloat(this.rad0); 
 
        outs.writeFloat(this.radstep); 
 
    }
 
    public laser_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public laser_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static april.lcmtypes.laser_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        april.lcmtypes.laser_t o = new april.lcmtypes.laser_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.nranges = ins.readInt();
 
        this.ranges = new float[(int) nranges];
        for (int a = 0; a < this.nranges; a++) {
            this.ranges[a] = ins.readFloat();
        }
 
        this.nintensities = ins.readInt();
 
        this.intensities = new float[(int) nintensities];
        for (int a = 0; a < this.nintensities; a++) {
            this.intensities[a] = ins.readFloat();
        }
 
        this.rad0 = ins.readFloat();
 
        this.radstep = ins.readFloat();
 
    }
 
    public april.lcmtypes.laser_t copy()
    {
        april.lcmtypes.laser_t outobj = new april.lcmtypes.laser_t();
        outobj.utime = this.utime;
 
        outobj.nranges = this.nranges;
 
        outobj.ranges = new float[(int) nranges];
        if (this.nranges > 0)
            System.arraycopy(this.ranges, 0, outobj.ranges, 0, this.nranges); 
        outobj.nintensities = this.nintensities;
 
        outobj.intensities = new float[(int) nintensities];
        if (this.nintensities > 0)
            System.arraycopy(this.intensities, 0, outobj.intensities, 0, this.nintensities); 
        outobj.rad0 = this.rad0;
 
        outobj.radstep = this.radstep;
 
        return outobj;
    }
 
}

