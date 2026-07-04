package com.hennnamushi.ironsspellsmoreinteraction.compat.asterismarcanum.tab;

import com.birdie.asterismarcanum.registries.ASARSpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.alshanex.alshanex_familiars.registry.PetSpellRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ASAR_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "asterismarcanum_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.asterismarcanum_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        ASARSpellRegistry.STARFIRE.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries, ASARSpellRegistry.STARFIRE.get());
                                addScrolls(entries, ASARSpellRegistry.BRIGHTBURST.get());
                                addScrolls(entries, ASARSpellRegistry.CELESTIAL_TETHER.get());
                                addScrolls(entries, ASARSpellRegistry.STAR_SWARM.get());
                                addScrolls(entries, ASARSpellRegistry.LUMINOUS_BEAM.get());
                                addScrolls(entries, ASARSpellRegistry.ASTRAL_GATEWAY.get());
                                addScrolls(entries, ASARSpellRegistry.SUMMON_LUNAR_MOTHS.get());
                                addScrolls(entries, ASARSpellRegistry.ASTRAL_ECHO.get());
                                addScrolls(entries, ASARSpellRegistry.PIERCING_LIGHT.get());
                                addScrolls(entries, ASARSpellRegistry.STARCUTTER.get());
                                addScrolls(entries, ASARSpellRegistry.SILVERY_BARBS.get());
                            })
                            .build()
            );

    private ASAR_Scroll() {}

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