package com.hennnamushi.ironsspellsmoreinteraction.compat.apotheosis.tab;

import dev.shadowsoffire.apotheosis.socket.gem.Gem;
import dev.shadowsoffire.apotheosis.socket.gem.GemRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class Mod_Apotheosis_Gem {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "irons_spells_more_interaction");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GEM_TABS =
            TABS.register(
                    "mod_apotheosis_gem",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.mod_apotheosis_gem_tab"))
                            .icon(Mod_Apotheosis_Gem::createIcon)
                            .displayItems((features, entries) -> {
                                addGem(entries, "abyssal");
                                addGem(entries, "annihilation");
                                addGem(entries, "aqua");
                                addGem(entries, "astral");
                                addGem(entries, "eldritch");
                                addGem(entries, "sand");
                                addGem(entries, "sound");
                                addGem(entries, "spirit");
                                addGem(entries, "symmetry");
                                addGem(entries, "technomancy");
                                addGem(entries, "wind");
                            })
                            .build());

    private Mod_Apotheosis_Gem() {
    }

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }

    private static ItemStack createIcon() {
        Gem gem = GemRegistry.INSTANCE.getValue(ResourceLocation.fromNamespaceAndPath("apotheosis", "core/eldritch"));
        if (gem != null) {
            return gem.toStack(Purity.NORMAL);
        }
        return new ItemStack(Items.AMETHYST_SHARD);
    }

    private static void addGem(CreativeModeTab.Output entries, String gemId) {
        Gem gem = GemRegistry.INSTANCE.getValue(ResourceLocation.fromNamespaceAndPath("apotheosis", "core/" + gemId));
        if (gem != null) {
            for (Purity purity : Purity.ALL_PURITIES) {
                entries.accept(gem.toStack(purity));
            }
        }
    }
}
