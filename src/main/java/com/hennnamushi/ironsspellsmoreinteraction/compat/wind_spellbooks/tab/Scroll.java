package com.hennnamushi.ironsspellsmoreinteraction.compat.wind_spellbooks.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.raptorzizi.wind_spellbooks.registries.ModSpellRegistry;

public class Scroll {

    public static final DeferredRegister<CreativeModeTab> SCROLL_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCROLL_TAB =
            SCROLL_TABS.register(
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

    private static void addScrolls(CreativeModeTab.Output entries, AbstractSpell spell) {
        for (int level = spell.getMinLevel(); level <= spell.getMaxLevel(); level++) {
            ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
            ISpellContainer.createScrollContainer(spell, level, stack);
            entries.accept(stack);
        }
    }

    public static void register(IEventBus eventBus) {
        SCROLL_TABS.register(eventBus);
    }
}