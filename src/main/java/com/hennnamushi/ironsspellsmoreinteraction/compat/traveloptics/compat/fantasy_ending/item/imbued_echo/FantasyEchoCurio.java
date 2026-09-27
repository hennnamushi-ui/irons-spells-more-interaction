package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.fantasy_ending.item.imbued_echo;

import com.gametechbc.traveloptics.api.item.AdvancedEchoCurio;
import com.mega.uom.auto.AutoRegisterManager;
import com.mega.uom.client.component.MegaFont;
import com.mega.uom.common.attribute.ModAttributes;
import com.mega.uom.common.context.ChatFormattingContext;
import com.mega.uom.common.spells.fantasy.attack.MultiStarArrowSpell;
import com.mega.uom.common.spells.fantasy.attack.MultipleEldritchBlastSpell;
import com.mega.uom.common.spells.fantasy.attack.SoltronCollapsingSpell;
import com.mega.uom.common.spells.fantasy.attack.StarArrowSpell;
import com.mega.uom.common.spells.fantasy.self.HealthReverseSpell;
import com.mega.uom.common.spells.fantasy.self.RunicShieldSpell;
import com.mega.uom.common.spells.fantasy.self.TimeStopSpell;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import com.mega.uom.common.context.ChatFormattingContext;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class FantasyEchoCurio extends AdvancedEchoCurio {
    public FantasyEchoCurio(Properties properties) {
        super(properties, getAttributes());
    }

    protected Map<AbstractSpell, SpellAttributes> getSpellAttributes() {
    Map<AbstractSpell, SpellAttributes> spells = new LinkedHashMap<>();

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(MultipleEldritchBlastSpell.class),
        new SpellAttributes(5, true, 0.1f, 1f)
    );

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(MultiStarArrowSpell.class),
        new SpellAttributes(5, true, 0.1f, 1f)
    );

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(StarArrowSpell.class),
        new SpellAttributes(10, true, 0.1f, 1f)
    );

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(HealthReverseSpell.class),
        new SpellAttributes(5, true, 0.1f, 1f)
    );

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(RunicShieldSpell.class),
        new SpellAttributes(8, true, 0.1f, 1f)
    );

    spells.put(
        AutoRegisterManager.INSTANCE().spell.get(TimeStopSpell.class),
        new SpellAttributes(9, true, 0.1f, 1f)
    );

    return spells;
}
    @Override
    protected Component getUnassignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.fantasy_echo_curio.unassigned.tooltip");
    }

    @Override
    protected Component getAssignedHoverText() {
        return Component.translatable("item.irons_spells_more_interaction.fantasy_echo_curio.assigned.tooltip")
                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @Nullable Font getFont(ItemStack stack, IClientItemExtensions.FontContext context) {
                return MegaFont.FantasyFont; // com.mega.uom.client.component.MegaFont
            }
        });
    }


    private static Map<Attribute, AttributeModifier> getAttributes() {
        Map<Attribute, AttributeModifier> map = new LinkedHashMap<>();
        map.put(
                ModAttributes.FANTASY_SPELL_POWER.get(),
                new AttributeModifier(
                        UUID.fromString("b2ab22ac-2935-4d39-8b60-68210e2f1730"),
                        "Fantasy spell power",
                        0.15D,
                        AttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        return map;
    }
}
