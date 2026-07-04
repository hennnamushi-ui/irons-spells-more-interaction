package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.legendary_spellbooks.item.imbued_echo.AnnihilationEchoCurio;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> ANNIHILATION_ECHO_CURIO = ITEMS.register("annihilation_echo_curio",
            () -> new AnnihilationEchoCurio(new Item.Properties().stacksTo(1))
    );
}
