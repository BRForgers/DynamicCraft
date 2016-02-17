package brazillianforgers.dynamiccraft.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

public enum KeyBindings {
	
	MODE("Change Mode", Keyboard.KEY_L);

    private final KeyBinding keybinding;

    private KeyBindings(String keyName, int defaultKeyCode){
        keybinding = new KeyBinding(keyName, defaultKeyCode, "Dynamic Craft");
    }

    public KeyBinding getKeybind(){
        return keybinding;
    }

    public boolean isPressed(){
        return keybinding.isPressed();
    }
}
