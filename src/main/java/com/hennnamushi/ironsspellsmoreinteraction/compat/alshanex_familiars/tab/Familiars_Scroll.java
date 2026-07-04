package com.hennnamushi.ironsspellsmoreinteraction.compat.alshanex_familiars.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.alshanex.alshanex_familiars.registry.PetSpellRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Familiars_Scroll {

    public static final DeferredRegister<CreativeModeTab> SCROLL_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCROLL_TAB =
            SCROLL_TABS.register(
                    "familiars_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.alshanex_familiars_spellbooks_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        PetSpellRegistry.SONATA.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries, PetSpellRegistry.SUMMON_SHADOW.get());
                                addScrolls(entries, PetSpellRegistry.DEFAULT_NOTE_SPELL.get());
                                addScrolls(entries, PetSpellRegistry.VIBRATION_SPELL.get());
                                addScrolls(entries, PetSpellRegistry.EXPLOSION_MELODY.get());
                                addScrolls(entries, PetSpellRegistry.ANGEL_SPELL.get());
                                addScrolls(entries, PetSpellRegistry.BIRDS_SPELL.get());
                                addScrolls(entries, PetSpellRegistry.MUSIC_BOLT.get());
                                addScrolls(entries, PetSpellRegistry.SONATA.get());
                                addScrolls(entries, PetSpellRegistry.LULLABY.get());
                                addScrolls(entries, PetSpellRegistry.ICE_AGE.get());
                                addScrolls(entries, PetSpellRegistry.ICE_CHAMBER.get());
                                addScrolls(entries, PetSpellRegistry.MEGIDO.get());
                                addScrolls(entries, PetSpellRegistry.HIKEN.get());
                                addScrolls(entries, PetSpellRegistry.MAYHEM.get());
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