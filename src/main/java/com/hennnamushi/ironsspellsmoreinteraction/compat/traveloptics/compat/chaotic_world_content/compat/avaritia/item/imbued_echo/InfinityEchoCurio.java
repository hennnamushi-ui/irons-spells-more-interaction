package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.chaotic_world_content.compat.avaritia.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import com.example.chaotic_world_content.infinity.InfinityMagicRegistry;
import com.example.chaotic_world_content.infinity.InfinitySpellSpec;
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

public class InfinityEchoCurio extends AdvancedEchoCurio {
    public InfinityEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap();
        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.WORLDBREAKER).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.INFINITY_GUARD).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.CRYSTAL_MATRIX).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.COSMIC_BARRAGE).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.INFINITE_RAIN).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.COSMIC_CLEAVE).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.NEUTRON_LANCE).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.SINGULARITY_COLLAPSE).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.ENDEST_REVERSAL).get(),
                new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(InfinityMagicRegistry.REGISTERED.get(InfinitySpellSpec.ABSOLUTE_END).get(),
                new SpellAttributes(5, true, 0.1f, 1f));
        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.infinity_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.infinity_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                InfinityMagicRegistry.INFINITY_SPELL_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "infinity spell power",
                        1.5D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
