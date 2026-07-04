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
import net.raptorzizi.wind_spellbooks.registries.ModItemsRegistry;
import net.raptorzizi.wind_spellbooks.registries.ModSpellRegistry;

public class Wind_Item {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "wind_spellbooks_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM_TABS =
            TABS.register(
                    "wind_item",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.wind_spellbooks_tab"))
                            .icon(() ->
                                new ItemStack(ModItemsRegistry.WIND_SPELL_BOOK.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ModItemsRegistry.WIND_STAFF.get());
                                output.accept(ModItemsRegistry.WIND_SPELL_BOOK.get());
                                output.accept(ModItemsRegistry.WIND_UPGRADE_ORB.get());
                                output.accept(ModItemsRegistry.WIND_RUNE.get());
                                output.accept(ModItemsRegistry.AEROMANCER_HELMET.get());
                                output.accept(ModItemsRegistry.AEROMANCER_CHESTPLATE.get());
                                output.accept(ModItemsRegistry.AEROMANCER_LEGGINGS.get());
                                output.accept(ModItemsRegistry.AEROMANCER_BOOTS.get());
                                output.accept(ModItemsRegistry.AEROMANCER_SPAWN_EGG.get());
                            })
                            .build()
            );
    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}