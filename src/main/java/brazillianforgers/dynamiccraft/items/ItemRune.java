package brazillianforgers.dynamiccraft.items;

import brazillianforgers.dynamiccraft.DynamicCraft;

public class ItemRune extends BaseItem {
	
	private RuneType type;
	
	public enum RuneType {
		AQUA,
		FIRE,
		EATH;
	}
	
	public ItemRune(int i) {
		setCreativeTab(DynamicCraft.dynamicTab);
		setMaxStackSize(1);
		setHasSubtypes(true);
		setMaxDamage(20);

		switch(i) {
			case 1:
				this.type = RuneType.AQUA;
				break;
			case 2:
				this.type = RuneType.FIRE;
				break;
			case 3:
				this.type = RuneType.EATH;
				break;
		}
		
		setName();
	}
	
	public void setName() {
		if(type == RuneType.AQUA) {
			setUnlocalizedName("aquaRune");
		}else if(type == RuneType.FIRE) {
			setUnlocalizedName("fireRune");
		}else if(type == RuneType.EATH) {
			setUnlocalizedName("earthRune");
		}
	}
	
}
