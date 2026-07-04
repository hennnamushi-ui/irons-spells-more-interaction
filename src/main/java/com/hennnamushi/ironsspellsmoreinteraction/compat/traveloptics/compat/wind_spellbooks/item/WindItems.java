package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.wind_spellbooks.item.imbued_echo.WindEchoCurio;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WindItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> WIND_ECHO_CURIO = ITEMS.register("wind_echo_curio",
            () -> new WindEchoCurio(new Item.Properties().stacksTo(1))
    );
}
