package com.mad.max.game.ecs.entity.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.util.TextureUtil;

public class TargetPosition extends Actor {

    private static final boolean DEBUG = true;

    public TargetPosition(float x, float y){
        super(x, y, 5, 5, initTexture(), GraphicComponent.Layer.Debug);
    }


    public static TextureRegion initTexture(){
        if(DEBUG){
            return TextureUtil.solidTexture(Color.PINK);
        }
        return TextureUtil.solidTexture(Color.CLEAR);
    }
}
