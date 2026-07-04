package com.hennnamushi.ironsspellsmoreinteraction;

import com.hennnamushi.ironsspellsmoreinteraction.compat.alshanex_familiars.tab.AF_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.apotheosis.tab.Mod_Apotheosis_Gem;
import com.hennnamushi.ironsspellsmoreinteraction.compat.asterismarcanum.tab.ASAR_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.cataclysm_spellbooks.tab.CS_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.iss_magicfromtheeast.tab.MFTE_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.somakespells.tab.Somake_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.tunes_n_tomes.tab.TNT_Scroll;
import com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab.Wind_Item;
import com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab.Wind_Scroll;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;

@Mod(IronsSpellsMoreInteraction.MOD_ID)
public final class IronsSpellsMoreInteraction {
    public static final String MOD_ID = "irons_spells_more_interaction";

    public IronsSpellsMoreInteraction(IEventBus modEventBus) {
        if (ModList.get().isLoaded("alshanex_familiars")) {
            AF_Scroll.register(modEventBus);
        }
        if (ModList.get().isLoaded("apotheosis")) {
            Mod_Apotheosis_Gem.register(modEventBus);
        }
        if (ModList.get().isLoaded("asterismarcanum")) {
            ASAR_Scroll.register(modEventBus);
        }
        if (ModList.get().isLoaded("cataclysm_spellbooks")) {
            CS_Scroll.register(modEventBus);
        }
        if  (ModList.get().isLoaded("iss_magicfromtheeast")) {
            MFTE_Scroll.register(modEventBus);
        }
        if (ModList.get().isLoaded("somakespells")) {
            Somake_Scroll.register(modEventBus);
        }
        if (ModList.get().isLoaded("tunes_n_tomes")) {
            TNT_Scroll.register(modEventBus);
        }
        if (ModList.get().isLoaded("wind_spellbooks")) {
            Wind_Scroll.register(modEventBus);
            Wind_Item.register(modEventBus);
        }
    }
}
