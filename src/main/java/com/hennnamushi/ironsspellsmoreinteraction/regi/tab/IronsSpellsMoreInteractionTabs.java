package com.hennnamushi.ironsspellsmoreinteraction.regi.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item.FamiliarsItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.CSItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item.LSItems;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item.WindItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction.*;

public class IronsSpellsMoreInteractionTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<CreativeModeTab> IRONS_SPELLS_MORE_INTERACTION_TAB =
            MOD_TABS.register(
                    "ironsspellsmoreinteraction",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.issmitab"))
                            .icon(() -> new ItemStack(FamiliarsItems.SOUND_ECHO_CURIO.get()))
                            .displayItems((params, output) -> {

                                if (IronsSpellsMoreInteraction.hasTravelopticsCompat()) {
                                   if (hasCataclysm_spellbooksCompat()) {
                                   output.accept(CSItems.TECHNO_ECHO_CURIO.get());
                                   output.accept(CSItems.ABYSSAL_ECHO_CURIO.get());
                                   }
                                   if (hasAlshanex_FamiliarsCompat()) {
                                   output.accept(FamiliarsItems.SOUND_ECHO_CURIO.get());
                                   }
                                   if (hasLegendary_SpellbooksCompat()) {
                                   output.accept(LSItems.ANNIHILATION_ECHO_CURIO.get());
                                   }
                                   if (hasWind_SpellbooksCompat()) {
                                   output.accept(WindItems.WIND_ECHO_CURIO.get());
                                   }
                                }
                            })
                            .build()
            );
}
