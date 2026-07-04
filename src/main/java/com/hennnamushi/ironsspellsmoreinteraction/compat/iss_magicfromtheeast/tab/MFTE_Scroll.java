package com.hennnamushi.ironsspellsmoreinteraction.compat.iss_magicfromtheeast.tab;

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
import net.warphan.iss_magicfromtheeast.registries.MFTESpellRegistries;

public class MFTE_Scroll {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "scroll_tabs");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TABS =
            TABS.register(
                    "magic_from_the_east_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.magic_from_the_east_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        MFTESpellRegistries.SWORD_DANCE_SPELL.get(), 1, stack);
                                return stack;
                            })
                            .displayItems((features, entries) -> {
                                addScrolls(entries, MFTESpellRegistries.SWORD_DANCE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.BAGUA_ARRAY_CIRCLE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.DRAGON_GLIDE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.JADE_JUDGEMENT_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.JIANGSHI_INVOKE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.UNDERWORLD_AID_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.PUNISHING_HEAVEN_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.DRAPES_OF_REFLECTION_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.CLOUD_RIDE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.NEPHRITE_SLASH_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.JADE_BULLET_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.SOUL_CATALYST_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.SOUL_BURST_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.SPIRIT_CHALLENGING.get());
                                addScrolls(entries, MFTESpellRegistries.BONE_HANDS_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.CALAMITY_CUT_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.KITSUNE_PACK_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.REVENANT_OF_HONOR_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.ASHIGARU_SQUAD_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.PHANTOM_CHARGE_SPELL.get());
                                addScrolls(entries, MFTESpellRegistries.ANCHORING_KUNAI.get());
                                addScrolls(entries, MFTESpellRegistries.SPLITTING_SHURIKEN.get());
                            })
                            .build()
            );

    private MFTE_Scroll() {}

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