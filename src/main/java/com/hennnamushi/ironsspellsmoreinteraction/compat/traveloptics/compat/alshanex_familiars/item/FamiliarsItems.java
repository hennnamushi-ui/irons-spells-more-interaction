package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.alshanex_familiars.item.imbued_echo.SoundEchoCurio;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FamiliarsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> SOUND_ECHO_CURIO = ITEMS.register("sound_echo_curio",
            () -> new SoundEchoCurio(new Item.Properties().stacksTo(1))
    );

}
