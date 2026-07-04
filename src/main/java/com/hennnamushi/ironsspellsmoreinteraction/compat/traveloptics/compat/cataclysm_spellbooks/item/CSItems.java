package com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.imbued_echo.AbyssalEchoCurio;
import com.hennnamushi.ironsspellsmoreinteraction.compat.traveloptics.compat.cataclysm_spellbooks.item.imbued_echo.TechnoEchoCurio;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Item> ABYSSAL_ECHO_CURIO = ITEMS.register("abyssal_echo_curio",
            () -> new AbyssalEchoCurio(new Item.Properties().stacksTo(1))
    );
    public static final RegistryObject<Item> TECHNO_ECHO_CURIO = ITEMS.register("techno_echo_curio",
            () -> new TechnoEchoCurio(new Item.Properties().stacksTo(1))
    );

}
