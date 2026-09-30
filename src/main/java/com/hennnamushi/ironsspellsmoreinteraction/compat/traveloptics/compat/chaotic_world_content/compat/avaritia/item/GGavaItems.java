package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.chaotic_world_content.compat.avaritia.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.chaotic_world_content.compat.avaritia.item.imbued_echo.InfinityEchoCurio;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GGavaItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> INFINITY_ECHO_CURIO = ITEMS.register("infinity_echo_curio",
            () -> new InfinityEchoCurio(new Item.Properties().stacksTo(1))
    );

}
