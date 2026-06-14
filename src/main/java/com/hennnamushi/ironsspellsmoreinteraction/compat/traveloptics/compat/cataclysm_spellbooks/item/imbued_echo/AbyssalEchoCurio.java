package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class AbyssalEchoCurio extends AdvancedEchoCurio {
    public AbyssalEchoCurio(Item.Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, AdvancedEchoCurio.SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, AdvancedEchoCurio.SpellAttributes> spells = new LinkedHashMap();
        spells.put(SpellRegistries.VOID_BEAM.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.ABYSSAL_BLAST.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.DIMENSIONAL_RIFT.get(), new SpellAttributes(6, true, 0.1f, 1f));

        spells.put(SpellRegistries.DEPTH_CHARGE.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.ABYSSAL_PREDATOR.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistries.ABYSSAL_SLASH.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.TIDAL_GRAB.get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(SpellRegistries.CONJURE_CORAL_GOLEM.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(SpellRegistries.CONJURE_CORALSSUS.get(), new SpellAttributes(1, true, 0.1f, 1f));

        spells.put(SpellRegistries.CONJURE_CLAWDIAN.get(), new SpellAttributes(1, true, 0.1f, 1f));

        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.abyssal_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.abyssal_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                CSAttributeRegistry.ABYSSAL_MAGIC_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "Abyssal spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
