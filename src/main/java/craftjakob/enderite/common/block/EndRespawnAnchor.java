package craftjakob.enderite.common.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.sounds.SoundEvents;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;

public class EndRespawnAnchor extends RespawnAnchorBlock {

    public EndRespawnAnchor(Properties properties) {
        super(properties);
    }

    private static boolean isRespawnFuel(ItemStack p_55849_) {
        return p_55849_.is(Items.ENDER_PEARL);
     }
    @Override
    public InteractionResult use(BlockState p_55874_, Level p_55875_, BlockPos p_55876_, Player p_55877_, InteractionHand p_55878_, BlockHitResult p_55879_) {
        ItemStack itemstack = p_55877_.getItemInHand(p_55878_);
        if (p_55878_ == InteractionHand.MAIN_HAND && !isRespawnFuel(itemstack) && isRespawnFuel(p_55877_.getItemInHand(InteractionHand.OFF_HAND))) {
           return InteractionResult.PASS;
        } else if (isRespawnFuel(itemstack) && canBeCharged(p_55874_)) {
           charge(p_55877_, p_55875_, p_55876_, p_55874_);
           if (!p_55877_.getAbilities().instabuild) {
              itemstack.shrink(1);
           }

           return InteractionResult.sidedSuccess(p_55875_.isClientSide);
        } else if (p_55874_.getValue(CHARGE) == 0) {
           return InteractionResult.PASS;
        } else if (!canSetSpawn(p_55875_)) {
           if (!p_55875_.isClientSide) {
              this.explode(p_55874_, p_55875_, p_55876_);
           }

           return InteractionResult.sidedSuccess(p_55875_.isClientSide);
        } else {
           if (!p_55875_.isClientSide) {
              ServerPlayer serverplayer = (ServerPlayer)p_55877_;
              if (serverplayer.getRespawnDimension() != p_55875_.dimension() || !p_55876_.equals(serverplayer.getRespawnPosition())) {
                 serverplayer.setRespawnPosition(p_55875_.dimension(), p_55876_, 0.0F, false, true);
                 p_55875_.playSound((Player)null, (double)p_55876_.getX() + 0.5D, (double)p_55876_.getY() + 0.5D, (double)p_55876_.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.BLOCKS, 1.0F, 1.0F);
                 return InteractionResult.SUCCESS;
              }
           }

           return InteractionResult.CONSUME;
        }
     }

    public static boolean canSetSpawn(Level p_55851_) {
        return p_55851_.dimensionType().hasFixedTime(); //hasFixedTime
     }

    private static boolean canBeCharged(BlockState p_55895_) {
        return p_55895_.getValue(CHARGE) < 4;
     }
    
    private static boolean isWaterThatWouldFlow(BlockPos p_55888_, Level p_55889_) {
        FluidState fluidstate = p_55889_.getFluidState(p_55888_);
        if (!fluidstate.is(FluidTags.WATER)) {
           return false;
        } else if (fluidstate.isSource()) {
           return true;
        } else {
           float f = (float)fluidstate.getAmount();
           if (f < 2.0F) {
              return false;
           } else {
              FluidState fluidstate1 = p_55889_.getFluidState(p_55888_.below());
              return !fluidstate1.is(FluidTags.WATER);
           }
        }
     }

    private void explode(BlockState p_55891_, Level p_55892_, final BlockPos p_55893_) {
        p_55892_.removeBlock(p_55893_, false);
        boolean flag = Direction.Plane.HORIZONTAL.stream().map(p_55893_::relative).anyMatch((p_55854_) -> {
           return isWaterThatWouldFlow(p_55854_, p_55892_);
        });
        final boolean flag1 = flag || p_55892_.getFluidState(p_55893_.above()).is(FluidTags.WATER);
        ExplosionDamageCalculator explosiondamagecalculator = new ExplosionDamageCalculator() {
           public Optional<Float> getBlockExplosionResistance(Explosion p_55904_, BlockGetter p_55905_, BlockPos p_55906_, BlockState p_55907_, FluidState p_55908_) {
              return p_55906_.equals(p_55893_) && flag1 ? Optional.of(Blocks.WATER.getExplosionResistance()) : super.getBlockExplosionResistance(p_55904_, p_55905_, p_55906_, p_55907_, p_55908_);
           }
        };
        Vec3 vec3 = p_55893_.getCenter();
        p_55892_.explode((Entity)null, p_55892_.damageSources().badRespawnPointExplosion(vec3), explosiondamagecalculator, vec3, 5.0F, true, Level.ExplosionInteraction.BLOCK);
     }
}