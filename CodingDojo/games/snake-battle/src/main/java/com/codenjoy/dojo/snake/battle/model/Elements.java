package com.codenjoy.dojo.snake.battle.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 Codenjoy
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


import com.codenjoy.dojo.services.printer.CharElements;

/**
 * Тут указана легенда всех возможных объектов на поле и их состояний.
 * Важно помнить, что для каждой енумной константы надо создать спрайт в папке \src\main\webapp\resources\sprite.
 */
public enum Elements implements CharElements {

    NONE(' '),       // например это пустое место, куда можно перейти герою
    WALL('☼'),       // а это стенка, через которую я хочу чтобы проходить нельзя было
    START_FLOOR('#'),       // место старта змей
    OTHER('?'),

    APPLE('○'),
    STONE('●'),
    FLYING_PILL('%'),
    FURY_PILL('@'),
    GOLD('$'),

    // игрок
    HEAD_DOWN('▼'),
    HEAD_LEFT('◄'),
    HEAD_RIGHT('►'),
    HEAD_UP('▲'),
    HEAD_DEAD('☻'),
    HEAD_EVIL('⊕'),
    HEAD_FLY('⊖'),
    HEAD_SLEEP('⬢'),

    TAIL_END_DOWN('↑'),
    TAIL_END_LEFT('→'),
    TAIL_END_UP('↓'),
    TAIL_END_RIGHT('←'),
    TAIL_INACTIVE('ᓕ'),

    BODY_HORIZONTAL('═'),
    BODY_VERTICAL('║'),
    BODY_LEFT_DOWN('╗'),
    BODY_LEFT_UP('╝'),
    BODY_RIGHT_DOWN('╔'),
    BODY_RIGHT_UP('╚'),

    // противник
    ENEMY_HEAD_DOWN('∨'),
    ENEMY_HEAD_LEFT('<'),
    ENEMY_HEAD_RIGHT('>'),
    ENEMY_HEAD_UP('∧'),
    ENEMY_HEAD_DEAD('☺'),
    ENEMY_HEAD_EVIL('⊗'),
    ENEMY_HEAD_FLY('⊘'),
    ENEMY_HEAD_SLEEP('⬡'),

    ENEMY_TAIL_END_DOWN('⇑'),
    ENEMY_TAIL_END_LEFT('⇒'),
    ENEMY_TAIL_END_UP('⇓'),
    ENEMY_TAIL_END_RIGHT('⇐'),
    ENEMY_TAIL_INACTIVE('ᓚ'),

    ENEMY_BODY_HORIZONTAL('—'),
    ENEMY_BODY_VERTICAL('|'),
    ENEMY_BODY_LEFT_DOWN('╕'),
    ENEMY_BODY_LEFT_UP('╜'),
    ENEMY_BODY_RIGHT_DOWN('╓'),
    ENEMY_BODY_RIGHT_UP('╙'),
    ;

    final char ch;

    Elements(char ch) {
        this.ch = ch;
    }

    @Override
    public char ch() {
        return ch;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public static Elements valueOf(char ch) {
        for (Elements el : Elements.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

}
