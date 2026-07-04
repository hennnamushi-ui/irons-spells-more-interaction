package com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.raptorzizi.wind_spellbooks.registries.ModItemsRegistry;

public class Wind_Item {
    public static final DeferredRegister<CreativeModeTab> ITEM_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEM_TAB =
            ITEM_TABS.register(
                    "wind_item",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.wind_spellbooks_item_tab"))
                            .icon(() -> new ItemStack(ModItemsRegistry.WIND_SPELL_BOOK.get()))
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
                            .build());
    public static void register(IEventBus eventBus) {
        ITEM_TABS.register(eventBus);
    }
}
