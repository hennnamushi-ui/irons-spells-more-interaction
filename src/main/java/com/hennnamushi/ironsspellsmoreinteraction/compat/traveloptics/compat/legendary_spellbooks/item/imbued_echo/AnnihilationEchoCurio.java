package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import dev.higurashi.legendary_spellbooks.registries.LSAttributeRegistry;
import dev.higurashi.legendary_spellbooks.registries.LSSpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class AnnihilationEchoCurio extends AdvancedEchoCurio {
    public AnnihilationEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap();
        spells.put(LSSpellRegistry.ANNIHILATION_ARROW_SPELL.get(), new SpellAttributes(8, true, 0.1f, 1f));

        spells.put(LSSpellRegistry.ANNIHILATION_SHOCKWAVE_SPELL.get(), new SpellAttributes(6, true, 0.1f, 1f));

        spells.put(LSSpellRegistry.ANNIHILATION_RESONANCE_SPELL.get(), new SpellAttributes(6, true, 0.1f, 1f));

        spells.put(LSSpellRegistry.SUMMON_FLAMEBORN_KNIGHTS_SPELL.get(), new SpellAttributes(6, true, 0.1f, 1f));

        spells.put(LSSpellRegistry.FLAMEBORN_DRIFT_SPELL.get(), new SpellAttributes(7, true, 0.1f, 1f));

        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.annihilation_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.annihilation_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                LSAttributeRegistry.ANNIHILATION_SPELL_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "Annihilation spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
