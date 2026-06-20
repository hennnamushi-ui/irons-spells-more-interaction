package com.hennnamushi.ironsspellsmoreinteraction;

import com.hennnamushi.ironsspellsmoreinteraction.compat.alshanex_familiars.tab.Familiars_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.cataclysm_spellbooks.tab.Cataclysm_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item.FamiliarsItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item.LSItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item.WindItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab.Wind_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.init.ModLootModifiers;
import com.hennnamushi.ironsspellsmoreinteraction.regi.tab.IronsSpellsMoreInteractionTabs;
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
        IronsSpellsMoreInteractionTabs.MOD_TABS.register(modEventBus);
        if (hasWind_SpellbooksCompat()){
            Wind_Scroll.SCROLL_TABS.register(modEventBus);
        }
        if (hasCataclysm_spellbooksCompat()) {
            Cataclysm_Scroll.SCROLL_TABS.register(modEventBus);
        }
        if (hasAlshanex_FamiliarsCompat()) {
            Familiars_Scroll.SCROLL_TABS.register(modEventBus);
        }
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
            if (hasWind_SpellbooksCompat()) {
                WindItems.ITEMS.register(bus);
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

    public static boolean hasWind_SpellbooksCompat() {
        return ModList.get().isLoaded("wind_spellbooks");
    }
}