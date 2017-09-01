package com.epam.dojo.expansion.services;

/*-
 * #%L
 * iCanCode - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 EPAM
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;
import com.epam.dojo.expansion.model.Forces;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mikhail_Udalyi on 22.06.2016.
 */

public class PrinterData {

    private List<String> layers;
    private Point offset;
    private List<Forces> forces;

    public PrinterData() {
        this.layers = new LinkedList<>();
    }

    public void setOffset(Point point) {
        offset = new PointImpl(point);
    }

    public void addLayer(String layer) {
        layers.add(layer.replaceAll("\n", ""));
    }

    public List<String> getLayers() {
        return layers;
    }

    public JSONObject getOffset() {
        JSONObject result = new JSONObject();
        result.put("x", offset.getX());
        result.put("y", offset.getY());
        return result;
    }

    public List<Forces> getForces() {
        return forces;
    }

    public void setForces(List<Forces> forces) {
        this.forces = forces;
    }

}
