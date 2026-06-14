package com.hennnamushi.ironsspellsmoreinteraction;

import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item.FamiliarsItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item.LSItems;
import com.hennnamushi.ironsspellsmoreinteraction.init.ModLootModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.CSItems;

@Mod(IronsSpellsMoreInteraction.MOD_ID)
public final class IronsSpellsMoreInteraction {
    public static final String MOD_ID = "irons_spells_more_interaction";

    public IronsSpellsMoreInteraction() {
        IEventBus modEventBus =FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
          ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        if (hasTravelopticsCompat()) {
            if (hasCataclysm_spellbooksCompat()) {
                CSItems.ITEMS.register(bus);
            }
            if (hasAlshanex_FamiliarsCompat()) {
                FamiliarsItems.ITEMS.register(bus);
            }
            if (hasLegendary_SpellbooksCompat()) {
                LSItems.ITEMS.register(bus);
            }
        }

    }

    public static boolean hasTravelopticsCompat() {
        return ModList.get().isLoaded("traveloptics");
    }

    public static boolean hasCataclysm_spellbooksCompat() {
        return ModList.get().isLoaded("cataclysm_spellbooks");
    }

    public static boolean hasAlshanex_FamiliarsCompat() {
        return ModList.get().isLoaded("alshanex_familiars");
    }

    public static boolean hasLegendary_SpellbooksCompat() {
        return ModList.get().isLoaded("legendary_spellbooks");
    }
}