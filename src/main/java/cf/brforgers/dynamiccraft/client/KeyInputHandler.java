package cf.brforgers.dynamiccraft.client;

import cf.brforgers.core.lib.ItemHelper;
import cf.brforgers.dynamiccraft.handler.ItemHandler;
import cf.brforgers.dynamiccraft.network.MessageModeWand;
import cf.brforgers.dynamiccraft.network.NetworkHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class KeyInputHandler {

    private KeyBindings getPressedKey() {
        for (KeyBindings key : KeyBindings.values()) {
            if (key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {
        KeyBindings key = getPressedKey();
        if (key != null) {
            switch (key) {
                case MODE:
                    if (Minecraft.getMinecraft().thePlayer.getHeldItem() == null || Minecraft.getMinecraft().thePlayer.
                            getHeldItem().getItem() != ItemHandler.fireWand)
                        return;

                    ItemStack w = Minecraft.getMinecraft().thePlayer.getHeldItem();

                    if (ItemHelper.getString(w, "mode", "PROJECTILE").equals("PROJECTILE")) {
                        NetworkHandler.sendToServer(new MessageModeWand("mode", "FIRE"));
                        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_GRAY +
                                "Fire Mode enabled!"));
                    } else if (ItemHelper.getString(w, "mode", "PROJECTILE").equals("FIRE")) {
                        NetworkHandler.sendToServer(new MessageModeWand("mode", "PROJECTILE"));
                        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_GRAY +
                                "Projectile Mode enabled!"));
                    }
                    break;
            }
        }
    }

}
