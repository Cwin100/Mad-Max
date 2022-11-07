package com.mad.max.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;
import java.util.Optional;

public class GraphicComponent implements Component {
    public TextureRegion texture;
    public Layer layer = Layer.Background;

    public enum Layer{
        Background(0),
        Truck(1),
        Room(2),
        RoomIcon(3),

        Character(4),
        MenuBackground(5),
        MenuButton(6),
        Debug(7);

        private final int value;

        Layer(int value) {
            this.value = value;
        }

        public static Optional<Layer> valueOf(int value) {
            return Arrays.stream(values())
                    .filter(layer -> layer.value == value)
                    .findFirst();
        }
    }

}
