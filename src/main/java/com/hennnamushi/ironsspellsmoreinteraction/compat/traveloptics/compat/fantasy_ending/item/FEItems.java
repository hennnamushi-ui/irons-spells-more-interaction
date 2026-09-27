package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.fantasy_ending.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.fantasy_ending.item.imbued_echo.FantasyEchoCurio;
import com.mega.uom.common.context.ChatFormattingContext;
import com.mega.uom.common.context.ItemRarityContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FEItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> FANTASY_ECHO_CURIO = ITEMS.register("fantasy_echo_curio",
            () -> new FantasyEchoCurio(new Item.Properties().stacksTo(1).rarity(ItemRarityContext.ORIGIN()))
    );
}
