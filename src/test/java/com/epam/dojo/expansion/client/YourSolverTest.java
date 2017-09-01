package com.epam.dojo.expansion.client;

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


import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.QDirection;
import com.epam.dojo.expansion.model.Forces;
import com.epam.dojo.expansion.model.ForcesMoves;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static com.codenjoy.dojo.services.PointImpl.pt;
import static com.epam.dojo.expansion.client.Command.*;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class YourSolverTest {

    private Solver ai;

    @Before
    public void setup() {
        ai = new YourSolver();
    }

    private Board board(String json, String layer1, String layer2) {
        Board board = (Board) new Board().forString(layer1, layer2);
        board.setSource(new JSONObject(json));
        return board;
    }

    @Test
    public void should() {
        assertL(
                "{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':10,'region':{'x':1,'y':5}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1...$│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....F│" +
                "└─────┘",
                "-------" +
                "-♥-----" +
                "-------" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(1, 5), 10))
                        .move(new ForcesMoves(pt(1, 5), 5, QDirection.RIGHT))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':9,'region':{'x':2,'y':5}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1...$│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....F│" +
                "└─────┘",
                "-------" +
                "-♥♥----" +
                "-------" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(2, 5), 10))
                        .move(new ForcesMoves(pt(2, 5), 5, QDirection.RIGHT))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':8,'region':{'x':3,'y':5}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1...$│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....F│" +
                "└─────┘",
                "-------" +
                "-♥♥♥---" +
                "-------" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(3, 5), 10))
                        .move(new ForcesMoves(pt(3, 5), 5, QDirection.RIGHT))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':7,'region':{'x':4,'y':5}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1...$│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....F│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥--" +
                "-------" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(4, 5), 10))
                        .move(new ForcesMoves(pt(4, 5), 5, QDirection.RIGHT))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':1,'region':{'x':4,'y':5}}," +
                        "{'count':6,'region':{'x':5,'y':5}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1....│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....E│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥♥-" +
                "-------" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(5, 5), 10))
                        .move(new ForcesMoves(pt(5, 5), 5, QDirection.DOWN))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':1,'region':{'x':4,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':5}}," +
                        "{'count':5,'region':{'x':5,'y':4}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1....│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....E│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥♥-" +
                "-----♥-" +
                "-------" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(5, 4), 10))
                        .move(new ForcesMoves(pt(5, 4), 5, QDirection.DOWN))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':1,'region':{'x':4,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':4}}," +
                        "{'count':4,'region':{'x':5,'y':3}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1....│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....E│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥♥-" +
                "-----♥-" +
                "-----♥-" +
                "-------" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(5, 3), 10))
                        .move(new ForcesMoves(pt(5, 3), 5, QDirection.DOWN))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':1,'region':{'x':4,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':4}}," +
                        "{'count':1,'region':{'x':5,'y':3}}," +
                        "{'count':3,'region':{'x':5,'y':2}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1....│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....E│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥♥-" +
                "-----♥-" +
                "-----♥-" +
                "-----♥-" +
                "-------" +
                "-------",
                Command.increase(new Forces(pt(5, 2), 10))
                        .move(new ForcesMoves(pt(5, 2), 5, QDirection.DOWN))
                        .build());

        assertL("{'myForcesColor':'♥'," +
                    "'forces':[" +
                        "{'count':1,'region':{'x':1,'y':5}}," +
                        "{'count':1,'region':{'x':2,'y':5}}," +
                        "{'count':1,'region':{'x':3,'y':5}}," +
                        "{'count':1,'region':{'x':4,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':5}}," +
                        "{'count':1,'region':{'x':5,'y':4}}," +
                        "{'count':1,'region':{'x':5,'y':3}}," +
                        "{'count':1,'region':{'x':5,'y':2}}," +
                        "{'count':2,'region':{'x':5,'y':1}}" +
                    "]" +
                "}",
                "╔═════┐" +
                "║1....│" +
                "║.....│" +
                "║.....│" +
                "║.....│" +
                "║....E│" +
                "└─────┘",
                "-------" +
                "-♥♥♥♥♥-" +
                "-----♥-" +
                "-----♥-" +
                "-----♥-" +
                "-----♥-" +
                "-------",
                doNothing());
    }

    private void assertL(String json, String layer1, String layer2, Command expected) {
        String actual = ai.get(board(json, layer1, layer2));
        assertEquals(expected.toString(), actual);
    }
}