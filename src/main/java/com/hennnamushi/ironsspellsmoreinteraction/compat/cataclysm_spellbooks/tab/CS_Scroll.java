package com.hennnamushi.ironsspellsmoreinteraction.compat.cataclysm_spellbooks.tab;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raptorzizi.wind_spellbooks.registries.ModSpellRegistry;

public class CS_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "cataclysm_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.cataclysm_spellbooks_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        SpellRegistries.ABYSSAL_BLAST.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries, SpellRegistries.VOID_BEAM.get());
                                addScrolls(entries, SpellRegistries.ABYSSAL_BLAST.get());
                                addScrolls(entries, SpellRegistries.DIMENSIONAL_RIFT.get());
                                addScrolls(entries, SpellRegistries.DEPTH_CHARGE.get());
                                addScrolls(entries, SpellRegistries.ABYSSAL_PREDATOR.get());
                                addScrolls(entries, SpellRegistries.ABYSSAL_SLASH.get());
                                addScrolls(entries, SpellRegistries.TIDAL_GRAB.get());
                                addScrolls(entries, SpellRegistries.VOID_RUNE.get());
                                addScrolls(entries, SpellRegistries.VOID_BULWARK.get());
                                addScrolls(entries, SpellRegistries.GRAVITY_STORM.get());
                                addScrolls(entries, SpellRegistries.GRAVITATION_PULL.get());
                                addScrolls(entries, SpellRegistries.PILFER.get());
                                addScrolls(entries, SpellRegistries.CONJURE_KOBOLEDIATOR.get());
                                addScrolls(entries, SpellRegistries.CONJURE_KOBOLETON.get());
                                addScrolls(entries, SpellRegistries.THOTHS_WITNESS.get());
                                addScrolls(entries, SpellRegistries.INCINERATION.get());
                                addScrolls(entries, SpellRegistries.INFERNAL_STRIKE.get());
                                addScrolls(entries, SpellRegistries.CONJURE_IGNITED_REINFORCEMENT.get());
                                addScrolls(entries, SpellRegistries.HELLISH_BLADE.get());
                                addScrolls(entries, SpellRegistries.BONE_STORM.get());
                                addScrolls(entries, SpellRegistries.BONE_PIERCE.get());
                                addScrolls(entries, SpellRegistries.ASHEN_BREATH.get());
                                addScrolls(entries, SpellRegistries.ABYSS_FIREBALL.get());
                                addScrolls(entries, SpellRegistries.TECTONIC_TREMBLE.get());
                                addScrolls(entries, SpellRegistries.MALEVOLENT_BATTLEFIELD.get());
                                addScrolls(entries, SpellRegistries.FORGONE_RAGE.get());
                                addScrolls(entries, SpellRegistries.CONJURE_THRALL.get());
                                addScrolls(entries, SpellRegistries.CURSED_RUSH.get());
                                addScrolls(entries, SpellRegistries.SANDSTORM.get());
                                addScrolls(entries, SpellRegistries.DESERT_WINDS.get());
                                addScrolls(entries, SpellRegistries.MONOLITH_CRASH.get());
                                addScrolls(entries, SpellRegistries.AMETHYST_PUNCTURE.get());
                                addScrolls(entries, SpellRegistries.CONJURE_AMETHYST_CRAB.get());
                                addScrolls(entries, SpellRegistries.PHARAOHS_WRATH.get());
                                addScrolls(entries, SpellRegistries.EMP.get());
                                addScrolls(entries, SpellRegistries.LOCK_ON.get());
                                addScrolls(entries, SpellRegistries.LASER_BOLT.get());
                                addScrolls(entries, SpellRegistries.ATOMIC_LASER.get());
                                addScrolls(entries, SpellRegistries.DOS_SWARM.get());
                                addScrolls(entries, SpellRegistries.MISSILE_LAUNCH.get());
                                addScrolls(entries, SpellRegistries.CONSTRUCT_WATCHERS.get());
                                addScrolls(entries, SpellRegistries.CONSTRUCT_PROWLER.get());
                                addScrolls(entries, SpellRegistries.DDOS.get());
                                addScrolls(entries, SpellRegistries.SHUTDOWN.get());
                                addScrolls(entries, SpellRegistries.REWIRE.get());
                                addScrolls(entries, SpellRegistries.HARDWARE_UPDATE.get());
                                addScrolls(entries, SpellRegistries.SOFTWARE_UPDATE.get());
                                addScrolls(entries, SpellRegistries.FLASH_BANG.get());
                                addScrolls(entries, SpellRegistries.AERIAL_ASSAULT.get());
                                addScrolls(entries, SpellRegistries.INTRUSION_PREVENTION_SYSTEM.get());
                                addScrolls(entries, SpellRegistries.OVERCHARGED.get());
                                addScrolls(entries, SpellRegistries.DISABLING_SWIPE.get());
                                addScrolls(entries, SpellRegistries.GEAR_SHIFT.get());
                                addScrolls(entries, SpellRegistries.REBOOT.get());
                                addScrolls(entries, SpellRegistries.SURVEILLANCE_DRONE.get());
                            })
                            .build()
            );

    private CS_Scroll() {}

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