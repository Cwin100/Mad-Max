package com.mad.max.game.ecs.components;

import com.badlogic.ashley.core.Component;

public class ClickComponent implements Component {
    public Runnable leftAction;
    public Runnable rightAction;

}
