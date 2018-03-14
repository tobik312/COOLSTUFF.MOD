package git.tobik312.coolstuffmod.event.smoking;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class RenderSmokingPlayer extends RenderPlayer{
		
    public RenderSmokingPlayer(RenderManager renderManager){
        super(renderManager);
        this.mainModel = (ModelPlayer) new ModelSmokingPlayer(0.0f,false);
    }
    
}
