package cofh.thermal.dynamics.handler;

import cofh.thermal.dynamics.api.TDynApi;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author covers1624
 */
public class GridContainerCapProvider implements ICapabilityProvider, INBTSerializable<ListNBT> {

    private final GridContainer instance;
    private final LazyOptional<GridContainer> instanceOpt;

    public GridContainerCapProvider(GridContainer instance) {

        this.instance = instance;
        this.instanceOpt = LazyOptional.of(() -> instance);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

        if (cap == TDynApi.GRID_CONTAINER_CAPABILITY) {
            return instanceOpt.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public ListNBT serializeNBT() {

        return instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(ListNBT nbt) {

        instance.deserializeNBT(nbt);
    }

}
