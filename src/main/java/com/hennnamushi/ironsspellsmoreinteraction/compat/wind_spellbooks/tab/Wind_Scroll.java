package com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab;

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
import net.raptorzizi.wind_spellbooks.registries.ModSpellRegistry;

public class Wind_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "wind_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.wind_spellbooks_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        ModSpellRegistry.WIND_JUMP_SPELL.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries, ModSpellRegistry.WIND_JUMP_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.TORNADO_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.IRON_SLASH_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.ACROBATICS_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.ALMIGHTY_PUSH_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.WIND_BLADE_SPELL.get());
                                addScrolls(entries, ModSpellRegistry.TAILWIND_SPELL.get());
                            })
                            .build()
            );

    private Wind_Scroll() {}

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