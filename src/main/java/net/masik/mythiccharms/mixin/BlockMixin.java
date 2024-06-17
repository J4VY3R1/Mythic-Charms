package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void earthOrderAndBlazingEmbraceEffect(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity == null) return;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmEarthsOrderEquipped((LivingEntity) entity) ||
                !CharmHelper.charmBlazingEmbraceEquipped((LivingEntity) entity) ||
                !CharmHelper.charmCombinationEarthsOrderAndBlazingEmbraceEnabled((LivingEntity) entity)) return;


        if (((LivingEntity) entity).getMainHandStack().isDamageable()) return;

        List<ItemStack> itemStacks = new ArrayList<>();

        for (ItemStack item : cir.getReturnValue()) {

            Optional<SmeltingRecipe> recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(item), world);

            itemStacks.add(recipe.isPresent() ? recipe.get().getOutput(world.getRegistryManager()): item);

        }

        cir.setReturnValue(itemStacks);

    }

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void botanicBlessingEffectDrop(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity == null) return;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmBotanicBlessingEquipped((LivingEntity) entity)) return;


        if (!(state.getBlock() instanceof CropBlock)) return;

        Random rand = new Random();

        List<ItemStack> itemStacks = cir.getReturnValue();

        itemStacks.forEach(itemStack -> itemStack.increment(rand.nextInt(0,2)));

        cir.setReturnValue(itemStacks);

    }

}