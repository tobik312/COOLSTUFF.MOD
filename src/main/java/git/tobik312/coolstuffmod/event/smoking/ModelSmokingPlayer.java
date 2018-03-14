package git.tobik312.coolstuffmod.event.smoking;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;

public class ModelSmokingPlayer extends ModelPlayer {

	public ModelSmokingPlayer(float modelSize, boolean smallArmsIn) {
		super(modelSize, smallArmsIn);
	}
	
	@Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale){
		
		float rotateAngleY = -((float)Math.PI / 3.5f) + this.bipedHead.rotateAngleY;
		float rotateAngleX = -((float)Math.PI / 1.67f) + this.bipedHead.rotateAngleX;
				
		this.bipedRightArm.showModel = false;

		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		
		this.bipedRightArm.showModel = true;
		
		this.bipedRightArm.rotateAngleY = rotateAngleY;
        this.bipedRightArm.rotateAngleX = rotateAngleX;
        	
		this.bipedRightArm.renderWithRotation(scale);
	}
	
}
