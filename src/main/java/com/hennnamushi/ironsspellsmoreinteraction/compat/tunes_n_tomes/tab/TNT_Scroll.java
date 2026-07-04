package com.hennnamushi.ironsspellsmoreinteraction.compat.tunes_n_tomes.tab;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.alshanex.tunes_n_tomes.registry.TSpellRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TNT_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "tunes_n_tomes_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.tunes_n_tomes_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        TSpellRegistry.CHORD_BLAST_SPELL.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries,TSpellRegistry.CHORD_BLAST_SPELL.get());
                                addScrolls(entries,TSpellRegistry.CRESCENDO_SPELL.get());
                                addScrolls(entries,TSpellRegistry.GRAND_FINALE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.CELESTIAL_CHANT_SPELL.get());
                                addScrolls(entries,TSpellRegistry.RHAPSODY_SPELL.get());
                                addScrolls(entries,TSpellRegistry.SONATA_SPELL.get());
                                addScrolls(entries,TSpellRegistry.SERENADE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.DAL_SEGNO_SPELL.get());
                                addScrolls(entries,TSpellRegistry.ENCORE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.FORTISSIMO_SPELL.get());
                                addScrolls(entries,TSpellRegistry.SWIFT_MELODY_SPELL.get());
                                addScrolls(entries,TSpellRegistry.HYMN_OF_HOPE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.SLUMBER_NOTE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.CLAMOR_NOTE_SPELL.get());
                                addScrolls(entries,TSpellRegistry.HARMONIC_ARIA_SPELL.get());
                                addScrolls(entries,TSpellRegistry.PIERCING_SOLO_SPELL.get());
                            })
                            .build()
            );

    private TNT_Scroll() {}

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