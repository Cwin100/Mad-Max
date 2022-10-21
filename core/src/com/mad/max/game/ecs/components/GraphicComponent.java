package com.mad.max.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.Arrays;
import java.util.Optional;

public class GraphicComponent implements Component {
    public Texture texture;
    public Layer layer = Layer.Background;

    public enum Layer{
        Background(0),
        Truck(1),

        Character(2),
        MenuBackground(3),
        MenuButton(4),
        Debug(5);

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
