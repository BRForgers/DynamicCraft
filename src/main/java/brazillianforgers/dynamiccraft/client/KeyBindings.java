package brazillianforgers.dynamiccraft.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

public enum KeyBindings {
	
	MODE("key.dynamiccraft.mode", Keyboard.KEY_APOSTROPHE);

    private final KeyBinding keybinding;

    private KeyBindings(String keyName, int defaultKeyCode){
        keybinding = new KeyBinding(keyName, defaultKeyCode, "key.categories.advancedMod");
    }

    public KeyBinding getKeybind(){
        return keybinding;
    }

    public boolean isPressed(){
        return keybinding.isPressed();
    }
}
