package cf.brforgers.dynamiccraft.api.infusion;

import net.minecraft.item.ItemStack;

public class InfusionAltarFuel {
    public ItemStack fuelItem;
    public int fuelAmount = 0;

    public InfusionAltarFuel(ItemStack fuel, int fuelValue) {
        fuelItem = fuel;
        fuelAmount = fuelValue;
    }
}
