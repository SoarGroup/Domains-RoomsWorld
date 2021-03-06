/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package april.lcmtypes;
 
import java.io.*;
import java.nio.*;
import java.util.*;
import lcm.lcm.*;
 
public final class procman_process_list_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public long init_utime;
    public boolean exit;
    public int nprocs;
    public april.lcmtypes.procman_process_t processes[];
 
    public procman_process_list_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x5718107b575e8c0dL;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class>());
    }
 
    public static long _hashRecursive(ArrayList<Class> classes)
    {
        if (classes.contains(april.lcmtypes.procman_process_list_t.class))
            return 0L;
 
        classes.add(april.lcmtypes.procman_process_list_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + april.lcmtypes.procman_process_t._hashRecursive(classes)
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
 
        outs.writeLong(this.init_utime); 
 
        outs.writeByte( this.exit ? 1 : 0); 
 
        outs.writeInt(this.nprocs); 
 
        for (int a = 0; a < this.nprocs; a++) {
            this.processes[a]._encodeRecursive(outs); 
        }
 
    }
 
    public procman_process_list_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public procman_process_list_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static april.lcmtypes.procman_process_list_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        april.lcmtypes.procman_process_list_t o = new april.lcmtypes.procman_process_list_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.init_utime = ins.readLong();
 
        this.exit = ins.readByte()!=0;
 
        this.nprocs = ins.readInt();
 
        this.processes = new april.lcmtypes.procman_process_t[(int) nprocs];
        for (int a = 0; a < this.nprocs; a++) {
            this.processes[a] = april.lcmtypes.procman_process_t._decodeRecursiveFactory(ins);
        }
 
    }
 
    public april.lcmtypes.procman_process_list_t copy()
    {
        april.lcmtypes.procman_process_list_t outobj = new april.lcmtypes.procman_process_list_t();
        outobj.utime = this.utime;
 
        outobj.init_utime = this.init_utime;
 
        outobj.exit = this.exit;
 
        outobj.nprocs = this.nprocs;
 
        outobj.processes = new april.lcmtypes.procman_process_t[(int) nprocs];
        for (int a = 0; a < this.nprocs; a++) {
            outobj.processes[a] = this.processes[a].copy();
        }
 
        return outobj;
    }
 
}

