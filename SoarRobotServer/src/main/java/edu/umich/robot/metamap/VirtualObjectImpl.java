/*
 * Copyright (c) 2011, Regents of the University of Michigan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package edu.umich.robot.metamap;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import april.config.Config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import edu.umich.robot.util.ImmutablePose;
import edu.umich.robot.util.Pose;

/**
 * Normal virtual object implementation, as opposed to a template/prototype or
 * robot representation.
 * 
 * @author voigtjr@gmail.com
 */
class VirtualObjectImpl implements VirtualObject
{
    private final int id;
    
    private final String name;
    
    private ImmutablePose pose = ImmutablePose.new2DInstance(0, 0);
    
    Map<String, String> properties = Maps.newConcurrentMap();
    
    private List<Double> size = Lists.newArrayList(0.25, 0.25);

    VirtualObjectImpl(String name, VirtualObjectTemplate template, int id)
    {
        this.id = id;
        this.name = name;
        this.pose = ImmutablePose.newInstance(template.getPose());
        this.properties.putAll(template.properties);
        this.size = Lists.newArrayList(template.getSize());
    }
    
    VirtualObjectImpl(String name, Config config, int id)
    {
        this.id = id;
        this.name = name;
        if (config.hasKey("pos"))
        {
            Pose p = new Pose(config.requireDoubles("pos"));
            p.setYaw(config.getDouble("theta", 0));
            setPose(p);
        }

        
        if (config.hasKey("size"))
        {
            double[] size = config.requireDoubles("size");
            setSize(size[0], size[1]);
        }

        for (String key : config.getKeys())
        {
            if (key.equals("pos") || key.equals("size") || key.equals("theta"))
                continue;
            properties.put(key, config.requireString(key));
        }
    }
    
    @Override
    public String toString()
    {
        return name + "/" + id + "@" + pose.toString();
    }
    
    void setPose(Pose pose)
    {
        this.pose = ImmutablePose.newInstance(pose);
    }
    
    void setSize(double x, double y)
    {
        size = Lists.newArrayList(x, y);
    }
    
    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public Pose getPose()
    {
        return pose;
    }

    public Map<String, String> getProperties()
    {
        return Collections.unmodifiableMap(properties);
    }

    public List<Double> getSize()
    {
        return Collections.unmodifiableList(size);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof VirtualObject)
        {
            VirtualObject vo = (VirtualObject)obj;
            return this.id == vo.getId();
        }
        return super.equals(obj);
    }
    
    @Override
    public int hashCode()
    {
        return Integer.valueOf(id).hashCode();
    }

    /**
     * Simply tests a specific property.
     * 
     * @return
     */
    boolean isDiffusable()
    {
        return "true".equals(properties.get("diffusable"));
    }

    /**
     * Sets a boolean property.
     * 
     * @param b
     */
    void setDiffused(boolean b)
    {
        properties.put("diffused", Boolean.toString(b));
    }

    /**
     * Checks a property.
     * 
     * @param color
     * @return
     */
    boolean isDiffusableByColor(String color)
    {
        return isDiffusable() && color.equals(properties.get("diffuse-color"));
    }

}
