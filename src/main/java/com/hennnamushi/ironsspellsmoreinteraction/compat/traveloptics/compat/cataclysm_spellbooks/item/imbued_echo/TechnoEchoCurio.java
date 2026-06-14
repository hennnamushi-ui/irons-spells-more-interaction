package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class TechnoEchoCurio extends AdvancedEchoCurio {
    public TechnoEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap();
        spells.put(SpellRegistries.EMP_BLAST .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.LOCK_ON .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.LASERBOLT .get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(SpellRegistries.ATOMIC_LASER .get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.DOS_SWARM .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.MISSILE_LAUNCH .get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.CONSTRUCT_WATCHERS .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.CONSTRUCT_PROWLER .get(), new SpellAttributes(1, true, 0.1f, 1f));

        spells.put(SpellRegistries.DDOS .get(), new SpellAttributes(8, true, 0.1f, 1f));


        spells.put(SpellRegistries.SHUTDOWN .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.REWIRE .get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.HARDWARE_UPDATE .get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.SOFTWARE_UPDATE .get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.FLASH_BANG .get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.AERIAL_ASSAULT .get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(SpellRegistries.INTRUSION_PREVENTION_SYSTEM .get(), new SpellAttributes(1, true, 0.1f, 1f));

        spells.put(SpellRegistries.OVERCHARGED .get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.PARTING_SHOT .get(), new SpellAttributes(1, true, 0.1f, 1f));

        spells.put(SpellRegistries.DISABLING_SWIPE .get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.GEAR_SHIFT .get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.REBOOT .get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.SURVEILLANCE_DRONE .get(), new SpellAttributes(8, true, 0.1f, 1f));
        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.techno_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.techno_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                CSAttributeRegistry.TECHNOMANCY_MAGIC_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "technomancy spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
