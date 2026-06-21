package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import dev.higurashi.legendary_spellbooks.registries.LSSpellRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.raptorzizi.wind_spellbooks.registries.ModAttributeRegistry;
import net.raptorzizi.wind_spellbooks.registries.ModSpellRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction.hasLegendary_SpellbooksCompat;

public class WindEchoCurio extends AdvancedEchoCurio {
    public WindEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
        Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap();
        spells.put(ModSpellRegistry.WIND_JUMP_SPELL.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.TORNADO_SPELL.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.IRON_SLASH_SPELL.get(), new SpellAttributes(5, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.ACROBATICS_SPELL.get(), new SpellAttributes(4, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.ALMIGHTY_PUSH_SPELL.get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.WIND_BLADE_SPELL.get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(ModSpellRegistry.TAILWIND_SPELL.get(), new SpellAttributes(3, true, 0.1f, 1f));

        spells.put(SpellRegistry.GUST_SPELL.get(), new SpellAttributes(10, true, 0.1f, 1f));

        spells.put(SpellRegistry.INVISIBILITY_SPELL.get(), new SpellAttributes(6, true, 0.1f, 1f));

        spells.put(SpellRegistry.THROW_SPELL.get(), new SpellAttributes(5, true, 0.1f, 1f));

        if (hasLegendary_SpellbooksCompat()) {
            spells.put(LSSpellRegistry.TORNADO_SPELL.get(), new SpellAttributes(10, true, 0.1f, 1f));

            spells.put(LSSpellRegistry.QUAD_TORNADO_SPELL.get(), new SpellAttributes(5, true, 0.1f, 1f));
            }
        return spells;
    }

    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.wind_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.wind_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.DARK_GREEN);
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                ModAttributeRegistry.WIND_SPELL_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "wind spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
