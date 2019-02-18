package com.epam.dojo.icancode.model.items;

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


import com.epam.dojo.icancode.model.Elements;
import com.epam.dojo.icancode.model.enums.FeatureItem;
import com.epam.dojo.icancode.model.interfaces.IField;

public class FieldItem extends BaseItem {

    protected IField field;

    public FieldItem(Elements element) {
        super(element);
    }

    public FieldItem(Elements element, FeatureItem[] features) {
        super(element, features);
    }

    public void setField(IField value) {
        field = value;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}