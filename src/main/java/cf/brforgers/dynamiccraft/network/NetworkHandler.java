package cf.brforgers.dynamiccraft.network;

import cf.brforgers.dynamiccraft.Strings;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
    private static SimpleNetworkWrapper INSTANCE;

    public static void initServerMessages() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Strings.MODID);
    }

    public static void initClientMessages() {
        if (INSTANCE == null)
            INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Strings.MODID);
        INSTANCE.registerMessage(MessageModeWand.class, MessageModeWand.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageSetFire.class, MessageSetFire.class, 1, Side.SERVER);
    }

    public static void sendToServer(IMessage message) {
        INSTANCE.sendToServer(message);
    }
}
