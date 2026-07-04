package com.hennnamushi.ironsspellsmoreinteraction.compat.somakespells.tab;


import com.somake.somakespells.registries.ModSpells;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Somake_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "somakespells_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.somakespells_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        ModSpells.HYDRO_SLASH.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {

                                addScrolls(entries, ModSpells.COMBUSTION.get());
                                addScrolls(entries, ModSpells.DAMNED_DEMOMANS.get());
                                addScrolls(entries, ModSpells.ERUPTION.get());
                                addScrolls(entries, ModSpells.FIRE_BLAST.get());
                                addScrolls(entries, ModSpells.FIRESTORM_VORTEX.get());
                                addScrolls(entries, ModSpells.PUMPKIN_BOMB.get());
                                addScrolls(entries, ModSpells.IGNIS_SHIELD.get());
                                addScrolls(entries, ModSpells.INCINERATOR_SLASH.get());
                                addScrolls(entries, ModSpells.ABYSSAL_BURN.get());
                                addScrolls(entries, ModSpells.FIRE_ORBS.get());
                                addScrolls(entries, ModSpells.ABYSSAL_ORBS.get());
                                addScrolls(entries, ModSpells.APOCALYPTIC_BURST.get());
                                addScrolls(entries, ModSpells.EARTHBOUND.get());
                                addScrolls(entries, ModSpells.SUBMERGE.get());
                                addScrolls(entries, ModSpells.TIDAL_GRASP.get());
                                addScrolls(entries, ModSpells.TSUNAMI.get());
                                addScrolls(entries, ModSpells.TIDAL_DASH.get());
                                addScrolls(entries, ModSpells.THUNDER_CLOUD.get());
                                addScrolls(entries, ModSpells.WATER_CONTROL.get());
                                addScrolls(entries, ModSpells.WATER_SPEAR.get());
                                addScrolls(entries, ModSpells.HYDRO_SLASH.get());
                                addScrolls(entries, ModSpells.SEA_SERPENT.get());
                                addScrolls(entries, ModSpells.SEA_SERPENT_JET.get());
                                addScrolls(entries, ModSpells.STORM_AURA.get());
                                addScrolls(entries, ModSpells.WATER_BALL.get());
                                addScrolls(entries, ModSpells.SUMMON_ZOMBIE.get());
                                addScrolls(entries, ModSpells.LIGHTNING_SPEAR.get());
                                addScrolls(entries, ModSpells.ENDER_CORRUPTION.get());
                                addScrolls(entries, ModSpells.PHANTOM_BARRAGE.get());
                                addScrolls(entries, ModSpells.OVERGROWTH.get());
                                addScrolls(entries, ModSpells.PERMAFROST.get());
                                addScrolls(entries, ModSpells.BLESSING.get());
                                //addScrolls(entries, ModSpells.BLESSED_CONNECTION.get());
                                //addScrolls(entries, ModSpells.GUARDIAN_CONNECTION.get());
                                //addScrolls(entries, ModSpells.CURSED_CONNECTION.get());
                                addScrolls(entries, ModSpells.BLOOD_RUSH.get());
                                addScrolls(entries, ModSpells.BLOOD_CUT.get());
                                addScrolls(entries, ModSpells.BLOODMARK.get());
                                addScrolls(entries, ModSpells.ELDRITCH_GAMBIT.get());
                                addScrolls(entries, ModSpells.CHAIN_CONNECTION.get());
                                addScrolls(entries, ModSpells.EVOCATION_FORTITUDE.get());
                                addScrolls(entries, ModSpells.REVERBERATION.get());
                                addScrolls(entries, ModSpells.SLUMBER_MELODY.get());
                                addScrolls(entries, ModSpells.RESONANT_PULSE.get());
                                addScrolls(entries, ModSpells.RAM_TCHUM.get());
                                addScrolls(entries, ModSpells.LIGHTNING_BALL.get());
                                addScrolls(entries, ModSpells.LIGHTNING_DANCE.get());
                                addScrolls(entries, ModSpells.LIGHTNING_FIELD.get());
                                addScrolls(entries, ModSpells.LIGHTNING_STRIKE.get());
                                addScrolls(entries, ModSpells.LIGHTNING_CUT.get());
                                addScrolls(entries, ModSpells.LIGHTNING_SPARK.get());
                                addScrolls(entries, ModSpells.LIGHTNING_SWARM.get());
                                addScrolls(entries, ModSpells.LIGHTNING_LASH.get());
                                addScrolls(entries, ModSpells.HALBERD_STRIKE.get());
                                addScrolls(entries, ModSpells.MIRROR_STRIKE.get());
                                addScrolls(entries, ModSpells.RENDER_RUSH.get());
                                addScrolls(entries, ModSpells.AXE_CLEAVE.get());
                                addScrolls(entries, ModSpells.DESERT_WRATH.get());
                                addScrolls(entries, ModSpells.SOUL_GRAB.get());
                                addScrolls(entries, ModSpells.SPIRIT_EMPOWERMENT.get());
                                addScrolls(entries, ModSpells.SYMMETRY_EMPOWERMENT.get());
                            })
                            .build()
            );

    private Somake_Scroll() {}

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }

    private static void addScrolls(CreativeModeTab.Output entries, AbstractSpell spell) {
        for (int level = spell.getMinLevel(); level <= spell.getMaxLevel(); level++) {
            ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
            ISpellContainer.createScrollContainer(spell, level, stack);
            entries.accept(stack);
        }
    }
}