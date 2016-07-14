package cf.brforgers.dynamiccraft.client;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public enum KeyBindings {

    MODE("Change Mode", Keyboard.KEY_L);

    private final KeyBinding keybinding;

    KeyBindings(String keyName, int defaultKeyCode) {
        keybinding = new KeyBinding(keyName, defaultKeyCode, "Dynamic Craft");
    }

    public KeyBinding getKeybind() {
        return keybinding;
    }

    public boolean isPressed() {
        return keybinding.isPressed();
    }
}
