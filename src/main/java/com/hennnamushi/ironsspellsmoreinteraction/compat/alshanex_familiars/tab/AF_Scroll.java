package com.hennnamushi.ironsspellsmoreinteraction.compat.alshanex_familiars.tab;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.alshanex.alshanex_familiars.registry.PetSpellRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AF_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "familiars_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.alshanex_familiars_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        PetSpellRegistry.ICE_AGE.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries,PetSpellRegistry.SUMMON_SHADOW.get());
                                addScrolls(entries,PetSpellRegistry.ICE_AGE.get());
                                addScrolls(entries,PetSpellRegistry.ICE_CHAMBER.get());
                                addScrolls(entries,PetSpellRegistry.MEGIDO.get());
                                addScrolls(entries,PetSpellRegistry.HIKEN.get());
                                addScrolls(entries,PetSpellRegistry.MAYHEM.get());
                                addScrolls(entries,PetSpellRegistry.FAMILIAR_SWAP.get());
                            })
                            .build()
            );

    private AF_Scroll() {}

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