package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.util.BotanicBlessingHelper;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerMixin {

    @Unique
    private int ticksInAir = 0;

    @Unique
    private int cropGrowTimer = 0;

    //featheredGrace
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void featheredGraceEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmFeatheredGraceEquipped(player)) return;


        if (!player.isOnGround() && !player.isClimbing() && !player.isInsideWaterOrBubbleColumn() &&
                !player.isFallFlying() && player.getVelocity().y < 0) {

            ticksInAir += 1;

        } else {

            ticksInAir = 0;

        }

        int ticksInAirCap = 40;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) &&
                CharmHelper.charmCombinationFeatheredGraceAndHighBoundsEnabled(player)) ticksInAirCap = 60;

        //weightlessFlow combo
        if (player.isSneaking() && (!CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player) ||
                (!CharmHelper.charmWeightlessFlowEquipped(player) &&
                        CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player)))) {
            return;
        }

        if (ticksInAir >= 8 && ticksInAir < ticksInAirCap) {

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0,
                    false, false, false));

            //AdvancementsHelper.grantAdvancement(player, new Identifier("mythic_charms:story/charm_feathered_grace"));

        }

        if (this.ticksInAir >= 40 && this.ticksInAir < ticksInAirCap) {

            player.addExhaustion(0.05F);

        }

    }

    //collectorsGift
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void collectorsGiftEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmCollectorsGiftEquipped(player)) return;


        Box box = Box.from(player.getPos()).expand(4);

        List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));

        entities.forEach(item -> {

            item.setVelocity(item.getVelocity().add(player.getPos().subtract(item.getPos()).multiply(0.03F)));

            item.velocityModified = true;

        });

    }

    //botanicBlessing
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void botanicBlessingEffect(CallbackInfo info){

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        java.util.Random rand = new java.util.Random();


        if (!CharmHelper.charmBotanicBlessingEquipped(player)) return;


        if (cropGrowTimer > 20) {

            cropGrowTimer = 0;

            for (BlockPos pos : BlockPos.iterate(new BlockPos(-4, 0, -4), new BlockPos(4, 1, 4))) {

                if (rand.nextInt(10) < 4) {

                    BlockPos blockPos = player.getBlockPos().add(pos);

                    BlockState blockState = player.getWorld().getBlockState(blockPos);

                    if (blockState.getBlock() instanceof CropBlock cropBlock) {

                        if (!cropBlock.isMature(blockState)) {

                            player.getWorld().setBlockState(blockPos, cropBlock.withAge(cropBlock.getAge(blockState) + 1));

                        }

                    }

//                    if (rand.nextInt(10) < 6 && blockState.getBlock() instanceof PlantBlock) {
//
//                        for (int i = 0; i < 8; i++) {
//
//                            if (blockState.contains(BotanicBlessingHelper.AGES.get(i))) {
//
//                                IntProperty property = BotanicBlessingHelper.AGES.get(i);
//
//                                if (!blockState.get(property).equals(BotanicBlessingHelper.MAX_AGES.get(i))) {
//
//                                    player.getWorld().setBlockState(blockPos, blockState.with(property, blockState.get(property) + 1));
//
//                                }
//
//                                break;
//
//                            }
//
//                        }
//
//                    }

                }

            }

        }

        cropGrowTimer++;

    }

    //weightlessFlow
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void weightlessFlowEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmWeightlessFlowEquipped(player)) {
            player.setNoGravity(false);
            return;
        }


        if (player.isSneaking()) {
            player.setNoGravity(false);
            return;
        }

        player.setNoGravity(true);

    }

}
