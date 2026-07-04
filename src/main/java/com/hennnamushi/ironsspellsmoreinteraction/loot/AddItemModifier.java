package com.hennnamushi.ironsspellsmoreinteraction.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {

    // 再帰呼び出し中かどうかを追跡するフラグ（スレッドごとに独立）
    private static final ThreadLocal<Boolean> IS_APPLYING = ThreadLocal.withInitial(() -> false);

    public static final Supplier<Codec<AddItemModifier>> CODEC = () ->
        RecordCodecBuilder.create(inst ->
            codecStart(inst)
                .and(ResourceLocation.CODEC
                    .fieldOf("loot_table")
                    .forGetter(m -> m.lootTableId))
                .and(Codec.FLOAT
                    .fieldOf("chance")
                    .forGetter(m -> m.chance))
                .apply(inst, AddItemModifier::new)
        );

    private final ResourceLocation lootTableId;
    private final float chance;

    public AddItemModifier(LootItemCondition[] conditionsIn,
                           ResourceLocation lootTableId,
                           float chance) {
        super(conditionsIn);
        this.lootTableId = lootTableId;
        this.chance = chance;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
                                                 LootContext context) {
        // 既にこのModifierが実行中なら何もしない（無限再帰防止）
        if (IS_APPLYING.get()) {
            return generatedLoot;
        }

        // chests/ 配下のみ対象
        ResourceLocation queriedId = context.getQueriedLootTableId();
        if (queriedId == null || !queriedId.getPath().startsWith("chests/")) {
            return generatedLoot;
        }

        // chance ゲート
        if (context.getRandom().nextFloat() > this.chance) {
            return generatedLoot;
        }

        // フラグを立てて追加テーブルを roll する
        IS_APPLYING.set(true);
        try {
            LootTable additionTable = context.getLevel().getServer()
                    .getLootData()
                    .getLootTable(this.lootTableId);
            additionTable.getRandomItems(context, generatedLoot::add);
        } finally {
            // 必ずフラグを戻す
            IS_APPLYING.set(false);
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}