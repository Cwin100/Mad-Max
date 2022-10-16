package com.mad.max.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

import java.util.Arrays;
import java.util.Optional;

public class ClickComponent implements Component {
    public Runnable leftAction;
    public Runnable rightAction;

}
