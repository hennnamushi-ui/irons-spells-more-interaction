package com.hennnamushi.ironsspellsmoreinteraction.init;

import com.hennnamushi.ironsspellsmoreinteraction.IronsSpellsMoreInteraction;
import com.hennnamushi.ironsspellsmoreinteraction.loot.AddItemModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    IronsSpellsMoreInteraction.MOD_ID);

    public static final RegistryObject<Codec<AddItemModifier>> ADD_ITEM =
            LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC);
}
