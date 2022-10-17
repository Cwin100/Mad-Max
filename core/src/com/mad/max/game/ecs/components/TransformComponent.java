package com.mad.max.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by barry on 12/8/15 @ 9:53 PM.
 */
public class TransformComponent implements Component {
    public final Vector2 position = new Vector2();
    public final Vector2 size = new Vector2();
    public float rotation = 0.0f;
    public boolean isHidden = false;

    public Vector2 getCenter(){
        return new Vector2(position).mulAdd(size, .5f);
    }
}
