package com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item.WindItems.ITEMS;

public final class item{

    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> WIND_ICON = registerIcon("wind_icon");

    private static RegistryObject<Item> registerIcon(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
