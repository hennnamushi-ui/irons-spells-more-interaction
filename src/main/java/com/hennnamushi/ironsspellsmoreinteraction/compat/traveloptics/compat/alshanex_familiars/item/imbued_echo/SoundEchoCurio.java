package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.alshanex.familiarslib.registry.AttributeRegistry;
import net.alshanex.alshanex_familiars.registry.PetSpellRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class SoundEchoCurio extends AdvancedEchoCurio {
    public SoundEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap();

        spells.put(PetSpellRegistry.DEFAULT_NOTE_SPELL.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.VIBRATION_SPELL.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.EXPLOSION_MELODY.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.ANGEL_SPELL.get(), new SpellAttributes(4, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.BIRDS_SPELL.get(), new SpellAttributes(4, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.MUSIC_BOLT.get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.SONATA.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(PetSpellRegistry.LULLABY.get(), new SpellAttributes(1, true, 0.1f, 1f));

        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.sound_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.sound_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                AttributeRegistry.SOUND_SPELL_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "Sound spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
