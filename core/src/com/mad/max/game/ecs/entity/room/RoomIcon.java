package com.mad.max.game.ecs.entity.room;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.entity.actors.GridActor;
import com.mad.max.game.managers.AssetLoader;

public class RoomIcon extends GridActor {

    private static final float ICON_SIZE = .75f;

    public RoomIcon(float gx, float gy, String textureId) {
        super(gm.getWidth() * (gx - (ICON_SIZE/2)), gm.getHeight() * (gy - (ICON_SIZE/2)), ICON_SIZE, ICON_SIZE, AssetLoader.getTexture(textureId), GraphicComponent.Layer.RoomIcon);
    }
}
