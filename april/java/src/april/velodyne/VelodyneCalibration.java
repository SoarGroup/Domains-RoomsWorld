package april.velodyne;

import java.util.*;

/** Intrinsic calibration data for Velodyne. **/
public class VelodyneCalibration
{
    static class Laser
    {
        double rcf;             // radians (rotational/yaw offset)
        double vcf;             // radians (vertical offset)
        double hcf;             // meters (horizontal off-axis offset)
        double rangeOffset;     // meters
        double rangeScaleOffset; // (scalar)
    }

    Laser  laser[];
    int    physical2logical[];
    int    logical2physical[];
    double sincos[][];

    public VelodyneCalibration()
    {
    }

    public final int logicalToPhysical(int logical)
    {
        return logical2physical[logical];
    }

    public final int physicalToLogical(int physical)
    {
        return physical2logical[physical];
    }

    public static VelodyneCalibration makeMITCalibration()
    {
        double cal[][] = new double[][] { { -0.129905, -0.396851, -0.040000, 0.500000, 0.000000 }, // laser 32
        { -0.073727, -0.387918, 0.040000, 0.500000, 0.000000 }, // laser 33
        { 0.083776, -0.200956, -0.040000, 0.400000, 0.000000 }, // laser 34
        { 0.130900, -0.192023, 0.040000, 0.530000, 0.000000 }, // laser 35
        { -0.006981, -0.378993, -0.040000, 0.360000, 0.000000 }, // laser 36
        { 0.038397, -0.370074, 0.040000, 0.420000, 0.000000 }, // laser 37
        { -0.038109, -0.432672, -0.040000, 0.540000, 0.000000 }, // laser 38
        { 0.017781, -0.423702, 0.040000, 0.470000, 0.000000 }, // laser 39
        { 0.109956, -0.361162, -0.040000, 0.460000, 0.000000 }, // laser 40
        { 0.165806, -0.352254, 0.040000, 0.520000, 0.000000 }, // laser 41
        { 0.075049, -0.414742, -0.040000, 0.450000, 0.000000 }, // laser 42
        { 0.136136, -0.405792, 0.040000, 0.570000, 0.000000 }, // laser 43
        { -0.127409, -0.289992, -0.040000, 0.470000, 0.000000 }, // laser 44
        { -0.073727, -0.281102, 0.040000, 0.490000, 0.000000 }, // laser 45
        { -0.150427, -0.343352, -0.040000, 0.500000, 0.000000 }, // laser 46
        { -0.094119, -0.334453, 0.040000, 0.500000, 0.000000 }, // laser 47
        { -0.008727, -0.272210, -0.040000, 0.320000, 0.000000 }, // laser 48
        { 0.041888, -0.263317, 0.040000, 0.400000, 0.000000 }, // laser 49
        { -0.026180, -0.325557, -0.040000, 0.420000, 0.000000 }, // laser 50
        { 0.017781, -0.316664, 0.040000, 0.380000, 0.000000 }, // laser 51
        { 0.104720, -0.254421, -0.040000, 0.420000, 0.000000 }, // laser 52
        { 0.152716, -0.245523, 0.040000, 0.430000, 0.000000 }, // laser 53
        { 0.091630, -0.307772, -0.040000, 0.550000, 0.000000 }, // laser 54
        { 0.136136, -0.298882, 0.040000, 0.600000, 0.000000 }, // laser 55
        { -0.122173, -0.183082, -0.040000, 0.330000, 0.000000 }, // laser 56
        { -0.075922, -0.174132, 0.040000, 0.380000, 0.000000 }, // laser 57
        { -0.150098, -0.236620, -0.040000, 0.510000, 0.000000 }, // laser 58
        { -0.098611, -0.227713, 0.040000, 0.520000, 0.000000 }, // laser 59
        { -0.011345, -0.165172, -0.040000, 0.380000, 0.000000 }, // laser 60
        { 0.038109, -0.156202, 0.040000, 0.540000, 0.000000 }, // laser 61
        { -0.033161, -0.218800, -0.040000, 0.530000, 0.000000 }, // laser 62
        { 0.015708, -0.209881, 0.040000, 0.500000, 0.000000 }, // laser 63
        { -0.078540, -0.124933, -0.040000, 0.380000, 0.000000 }, // laser 0
        { -0.049126, -0.118993, 0.040000, 0.500000, 0.000000 }, // laser 1
        { 0.058469, 0.005547, -0.040000, 0.240000, 0.000000 }, // laser 2
        { 0.086468, 0.011486, 0.040000, 0.460000, 0.000000 }, // laser 3
        { -0.001745, -0.113056, -0.040000, 0.300000, 0.000000 }, // laser 4
        { 0.028798, -0.107121, 0.040000, 0.420000, 0.000000 }, // laser 5
        { -0.017453, -0.148716, -0.040000, 0.420000, 0.000000 }, // laser 6
        { 0.013090, -0.142766, 0.040000, 0.430000, 0.000000 }, // laser 7
        { 0.074176, -0.101188, -0.040000, 0.440000, 0.000000 }, // laser 8
        { 0.099484, -0.095256, 0.040000, 0.500000, 0.000000 }, // laser 9
        { 0.056723, -0.136819, -0.040000, 0.430000, 0.000000 }, // laser 10
        { 0.090757, -0.130875, 0.040000, 0.530000, 0.000000 }, // laser 11
        { -0.078889, -0.053760, -0.040000, 0.340000, 0.000000 }, // laser 12
        { -0.049126, -0.047833, 0.040000, 0.400000, 0.000000 }, // laser 13
        { -0.094248, -0.089326, -0.040000, 0.350000, 0.000000 }, // laser 14
        { -0.060214, -0.083396, 0.040000, 0.420000, 0.000000 }, // laser 15
        { -0.004363, -0.041906, -0.040000, 0.380000, 0.000000 }, // laser 16
        { 0.025403, -0.035978, 0.040000, 0.440000, 0.000000 }, // laser 17
        { -0.017453, -0.077468, -0.040000, 0.320000, 0.000000 }, // laser 18
        { 0.011854, -0.071540, 0.040000, 0.400000, 0.000000 }, // laser 19
        { 0.071558, -0.030050, -0.040000, 0.300000, 0.000000 }, // laser 20
        { 0.100356, -0.024121, 0.040000, 0.320000, 0.000000 }, // laser 21
        { 0.055851, -0.065613, -0.040000, 0.430000, 0.000000 }, // laser 22
        { 0.090757, -0.059687, 0.040000, 0.450000, 0.000000 }, // laser 23
        { -0.078540, 0.017428, -0.040000, 0.350000, 0.000000 }, // laser 24
        { -0.052360, 0.023372, 0.040000, 0.075000, 0.000000 }, // laser 25
        { -0.092502, -0.018190, -0.040000, 0.400000, 0.000000 }, // laser 26
        { -0.062694, -0.012259, 0.040000, 0.480000, 0.000000 }, // laser 27
        { -0.001745, 0.029320, -0.040000, 0.350000, 0.000000 }, // laser 28
        { 0.025403, 0.035270, 0.040000, 0.390000, 0.000000 }, // laser 29
        { -0.017453, -0.006325, -0.040000, 0.360000, 0.000000 }, // laser 30
        { 0.011854, -0.000390, 0.040000, 0.420000, 0.000000 }, // laser 31
        };
        VelodyneCalibration calib = new VelodyneCalibration();
        calib.laser = new Laser[64];
        for (int i = 0; i < 64; i++)
        {
            calib.laser[i] = new Laser();
            calib.laser[i].rcf = cal[i][0];
            calib.laser[i].vcf = cal[i][1];
            calib.laser[i].hcf = cal[i][2];
            calib.laser[i].rangeOffset = cal[i][3];
            calib.laser[i].rangeScaleOffset = cal[i][4];
        }
        calib.precompute();
        return calib;
    }

    /*
     * public static VelodyneCalibration makeFRACalibration() { final double cal[][] = new double[][] { { -6.5, -22.737886, 107, 16.019152, -2.5999999, }, // 32 { -4, -22.226072, 90, 15.954137, 2.5999999, }, // 33 { 5.5, -11.513928, 121, 14.680806, -2.5999999, }, // 34 { 8.5, -11.002114, 91, 14.623099, 2.5999999, }, // 35 { 0, -21.714685, 103, 15.889649, -2.5999999, }, // 36 { 3.4000001,
     * -21.203688, 85, 15.82566, 2.5999999, }, // 37 { -1.7, -24.790272, 107, 16.284933, -2.5999999, }, // 38 { 1.7, -24.276321, 86, 16.217583, 2.5999999, }, // 39 { 7, -20.693031, 105, 15.762167, -2.5999999, }, // 40 { 10, -20.182682, 90, 15.699132, 2.5999999, }, // 41 { 6, -23.762968, 105, 16.15085, -2.5999999, }, // 42 { 8.1999998, -23.250172, 77, 16.084715, 2.5999999, }, // 43 { -6,
     * -16.615318, 105, 15.26925, -2.5999999, }, // 44 { -4, -16.105938, 90, 15.209245, 2.5999999, }, // 45 { -8, -19.672594, 114, 15.63654, -2.5999999, }, // 46 { -5, -19.162729, 87, 15.574372, 2.5999999, }, // 47 { 0, -15.596496, 107, 15.14954, -2.5999999, }, // 48 { 2.5999999, -15.086954, 89, 15.090119, 2.5999999, }, // 49 { -1, -18.653046, 121, 15.51261, -2.5999999, }, // 50 { 1.5, -18.143503,
     * 90, 15.451235, 2.5999999, }, // 51 { 7, -14.577271, 108, 15.030966, -2.5999999, }, // 52 { 10, -14.067405, 84, 14.972065, 2.5999999, }, // 53 { 6, -17.634062, 114, 15.390228, -2.5999999, }, // 54 { 8.5, -17.124681, 91, 15.329572, 2.5999999, }, // 55 { -6.5, -10.489829, 121, 14.565539, -2.5999999, }, // 56 { -3.5, -9.9770317, 99, 14.508112, 2.5999999, }, // 57 { -7.4000001, -13.557318, 126,
     * 14.913401, -2.5999999, }, // 58 { -4.9000001, -13.046968, 95, 14.854958, 2.5999999, }, // 59 { 0.30000001, -9.4636793, 118, 14.450804, -2.5999999, }, // 60 { 2.5, -8.949728, 92, 14.3936, 2.5999999, }, // 61 { -1, -12.536313, 122, 14.796721, -2.5999999, }, // 62 { 1.5, -12.025314, 90, 14.738676, 2.5999999, }, // 63 { -3.7, -7.1581192, 103, 21.560343, -2.5999999, }, // 0 { -2, -6.8178215,
     * 124, 21.516994, 2.5999999, }, // 1 { 4.5999999, 0.31782165, 130, 20.617426, -2.5999999, }, // 2 { 6, 0.65811908, 122, 20.574717, 2.5999999, }, // 3 { 0.5, -6.4776502, 107, 21.473722, -2.5999999, }, // 4 { 2, -6.1375928, 128, 21.430525, 2.5999999, }, // 5 { 0, -8.520812, 111, 21.734608, -2.5999999, }, // 6 { 1.5, -8.1798887, 130, 21.690901, 2.5999999, }, // 7 { 5, -5.797637, 109, 21.387396,
     * -2.5999999, }, // 8 { 6.5999999, -5.4577708, 127, 21.34433, 2.5999999, }, // 9 { 4.4000001, -7.8391404, 111, 21.647291, -2.5999999, }, // 10 { 5.5, -7.4985547, 128, 21.603773, 2.5999999, }, // 11 { -3.5, -3.0802133, 112, 21.044245, -2.5999999, }, // 12 { -2.3, -2.7406337, 137, 21.001518, 2.5999999, }, // 13 { -4.5, -5.1179824, 117, 21.301321, -2.5999999, }, // 14 { -3, -4.7782598, 133,
     * 21.258366, 2.5999999, }, // 15 { 0.5, -2.4010365, 117, 20.958813, -2.5999999, }, // 16 { 2.3, -2.0614092, 131, 20.916126, 2.5999999, }, // 17 { -0.1, -4.4385905, 114, 21.215462, -2.5999999, }, // 18 { 1, -4.0989642, 129, 21.172602, 2.5999999, }, // 19 { 5, -1.7217404, 117, 20.873451, -2.5999999, }, // 20 { 6.3000002, -1.3820176, 131, 20.830786, 2.5999999, }, // 21 { 4, -3.7593663, 121,
     * 21.129782, -2.5999999, }, // 22 { 5.4000001, -3.4197867, 135, 21.086998, 2.5999999, }, // 23 { -3.3, 0.998555, 119, 20.531982, -2.5999999, }, // 24 { -2, 1.339141, 131, 20.489222, 2.5999999, }, // 25 { -4.3000002, -1.0422293, 130, 20.788124, -2.5999999, }, // 26 { -3, -0.70236301, 121, 20.745461, 2.5999999, }, // 27 { 0.60000002, 1.679889, 120, 20.446428, -2.5999999, }, // 28 { 2,
     * 2.0208123, 132.5, 20.403601, 2.5999999, }, // 29 { -0.30000001, -0.36240739, 129, 20.702793, -2.5999999, }, // 30 { 1.3, -0.022349782, 133, 20.660116, 2.5999999, }, // 31 };
     * 
     * VelodyneCalibration calib = new VelodyneCalibration(); calib.laser = new Laser[64]; for (int i = 0; i < 64; i++) { calib.laser[i] = new Laser(); calib.laser[i].rcf = cal[i][0]; calib.laser[i].vcf = cal[i][1]; calib.laser[i].hcf = cal[i][2]; calib.laser[i].rangeOffset = cal[i][3]; calib.laser[i].rangeScaleOffset = cal[i][4]; }
     * 
     * calib.precompute();
     * 
     * return calib; }
     */
    class MInt implements Comparable<MInt>
    {
        int   v;
        Laser laser;

        MInt(int v, Laser laser)
        {
            this.v = v;
            this.laser = laser;
        }

        public int compareTo(MInt a)
        {
            return Double.compare(a.laser.vcf, laser.vcf);
        }
    }

    void precompute()
    {
        ArrayList<MInt> tmp = new ArrayList<MInt>();
        for (int i = 0; i < Velodyne.NUM_LASERS; i++)
            tmp.add(new MInt(i, laser[i]));
        Collections.sort(tmp);
        logical2physical = new int[Velodyne.NUM_LASERS];
        physical2logical = new int[Velodyne.NUM_LASERS];
        for (int i = 0; i < Velodyne.NUM_LASERS; i++)
        {
            logical2physical[i] = tmp.get(i).v;
        }
        for (int logical = 0; logical < Velodyne.NUM_LASERS; logical++)
        {
            physical2logical[logical2physical[logical]] = logical;
        }
        sincos = new double[Velodyne.NUM_LASERS][2];
        for (int physical = 0; physical < Velodyne.NUM_LASERS; physical++)
        {
            sincos[physical][0] = Math.sin(laser[physical].vcf);
            sincos[physical][1] = Math.cos(laser[physical].vcf);
        }
    }
}
