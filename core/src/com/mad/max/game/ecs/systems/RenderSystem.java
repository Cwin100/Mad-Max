package com.mad.max.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.TextComponent;
import com.mad.max.game.ecs.components.TransformComponent;

public class RenderSystem extends SortedIteratingSystem {

    private final ComponentMapper<GraphicComponent> graphicM = ComponentMapper.getFor(GraphicComponent.class);
    private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);
    private final ComponentMapper<TextComponent> textM = ComponentMapper.getFor(TextComponent.class);
    private final Batch batch;

    public RenderSystem(Batch batch) {
        super(Family.all(GraphicComponent.class, TransformComponent.class).get(),
                new LayerComparator());
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = transformM.get(entity);
        GraphicComponent graphic = graphicM.get(entity);
        TextComponent text = textM.get(entity);

        batch.draw(graphic.texture, transform.position.x, transform.position.y, transform.size.x, transform.size.y);
        if(text != null){

            final GlyphLayout layout = new GlyphLayout(text.font, text.text);
            final float fontX = transform.position.x + (transform.size.x - layout.width) / 2;
            final float fontY = transform.position.y + (transform.size.y + layout.height) / 2;

            text.font.draw(batch, text.text , fontX, fontY);
        }
    }
}
