package com.hennnamushi.ironsspellsmoreinteraction.compat.cataclysm_spellbooks.tab;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Cataclysm_Scroll {

    public static final DeferredRegister<CreativeModeTab> SCROLL_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCROLL_TAB =
            SCROLL_TABS.register(
                    "cataclysm_scroll",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.cataclysm_spellbooks_scroll_tab"))
                            .icon(() -> {
                                ItemStack stack = new ItemStack((ItemLike) ItemRegistry.SCROLL.get());
                                ISpellContainer.createScrollContainer(
                                        SpellRegistries.VOID_BEAM.get(), 1, stack);
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
                                addScrolls(entries, SpellRegistries.CONJURE_CORAL_GOLEM.get());
                                addScrolls(entries, SpellRegistries.CONJURE_CORALSSUS.get());
                                addScrolls(entries, SpellRegistries.CONJURE_CLAWDIAN.get());
                                addScrolls(entries, SpellRegistries.HEMORRHAGING_IMPACT.get());
                                addScrolls(entries, SpellRegistries.QUICK_STRIKE.get());
                                addScrolls(entries, SpellRegistries.FINAL_REND.get());
                                addScrolls(entries, SpellRegistries.VOID_RUNE.get());
                                addScrolls(entries, SpellRegistries.VOID_BULWARK.get());
                                addScrolls(entries, SpellRegistries.GRAVITY_STORM.get());
                                addScrolls(entries, SpellRegistries.GRAVITATION_PULL.get());
                                addScrolls(entries, SpellRegistries.PILFER.get());
                                addScrolls(entries, SpellRegistries.CONJURE_KOBOLDIATOR.get());
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
                                addScrolls(entries, SpellRegistries.METEOR_SPEW.get());
                                addScrolls(entries, SpellRegistries.COMET_SHOWER.get());
                                addScrolls(entries, SpellRegistries.SCORCHED_EARTH.get());
                                addScrolls(entries, SpellRegistries.MALEVOLENT_BATTLEFIELD.get());
                                addScrolls(entries, SpellRegistries.FORGONE_RAGE.get());
                                addScrolls(entries, SpellRegistries.CONJURE_THRALL.get());
                                addScrolls(entries, SpellRegistries.CURSED_RUSH.get());
                                addScrolls(entries, SpellRegistries.PHANTASMAL_BLADE.get());
                                addScrolls(entries, SpellRegistries.CRYOPIERCER.get());
                                addScrolls(entries, SpellRegistries.SANDSTORM.get());
                                addScrolls(entries, SpellRegistries.DESERT_WINDS.get());
                                addScrolls(entries, SpellRegistries.MONOLITH_CRASH.get());
                                addScrolls(entries, SpellRegistries.AMETHYST_PUNCTURE.get());
                                addScrolls(entries, SpellRegistries.CONJURE_AMETHYST_CRAB.get());
                                addScrolls(entries, SpellRegistries.PHARAOHS_WRATH.get());
                                addScrolls(entries, SpellRegistries.EMP_BLAST.get());
                                addScrolls(entries, SpellRegistries.LOCK_ON.get());
                                addScrolls(entries, SpellRegistries.LASERBOLT.get());
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
                                addScrolls(entries, SpellRegistries.PARTING_SHOT.get());
                                addScrolls(entries, SpellRegistries.DISABLING_SWIPE.get());
                                addScrolls(entries, SpellRegistries.GEAR_SHIFT.get());
                                addScrolls(entries, SpellRegistries.REBOOT.get());
                                addScrolls(entries, SpellRegistries.SURVEILLANCE_DRONE.get());
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