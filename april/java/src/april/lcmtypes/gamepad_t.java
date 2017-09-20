/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package april.lcmtypes;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class gamepad_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public boolean present;
    public int naxes;
    public double axes[];
    public long buttons;
 
    public gamepad_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x345b96879832ec32L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(april.lcmtypes.gamepad_t.class))
            return 0L;
 
        classes.add(april.lcmtypes.gamepad_t.class);
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
 
        outs.writeByte( this.present ? 1 : 0); 
 
        outs.writeInt(this.naxes); 
 
        for (int a = 0; a < this.naxes; a++) {
            outs.writeDouble(this.axes[a]); 
        }
 
        outs.writeLong(this.buttons); 
 
    }
 
    public gamepad_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public gamepad_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static april.lcmtypes.gamepad_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        april.lcmtypes.gamepad_t o = new april.lcmtypes.gamepad_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.present = ins.readByte()!=0;
 
        this.naxes = ins.readInt();
 
        this.axes = new double[(int) naxes];
        for (int a = 0; a < this.naxes; a++) {
            this.axes[a] = ins.readDouble();
        }
 
        this.buttons = ins.readLong();
 
    }
 
    public april.lcmtypes.gamepad_t copy()
    {
        april.lcmtypes.gamepad_t outobj = new april.lcmtypes.gamepad_t();
        outobj.utime = this.utime;
 
        outobj.present = this.present;
 
        outobj.naxes = this.naxes;
 
        outobj.axes = new double[(int) naxes];
        if (this.naxes > 0)
            System.arraycopy(this.axes, 0, outobj.axes, 0, this.naxes); 
        outobj.buttons = this.buttons;
 
        return outobj;
    }
 
}

