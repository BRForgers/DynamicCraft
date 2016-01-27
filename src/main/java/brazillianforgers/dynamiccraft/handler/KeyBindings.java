package brazillianforgers.dynamiccraft.handler;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

public class KeyBindings {
    
    /** Key index for easy handling */
	public static final int APOSTROPHE = 0;
    private static final int[] keyValues = {Keyboard.KEY_APOSTROPHE};

	public static KeyBinding mode;
    
    public KeyBindings() {
		mode = new KeyBinding("Change Mode", keyValues[APOSTROPHE], StatCollector.translateToLocal("Dynamic Craft"));
		
		ClientRegistry.registerKeyBinding(mode);
	}
}
