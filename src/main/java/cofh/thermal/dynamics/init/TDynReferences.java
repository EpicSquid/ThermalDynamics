package cofh.thermal.dynamics.init;

import cofh.thermal.dynamics.api.grid.IGridType;
import cofh.thermal.dynamics.api.grid.energy.IEnergyGrid;
import cofh.thermal.dynamics.api.grid.fluid.IFluidGrid;
import cofh.thermal.dynamics.api.grid.item.IItemGrid;
import cofh.thermal.dynamics.api.grid.multi.IMultiGrid;
import cofh.thermal.dynamics.inventory.container.EnergyDistributorContainer;
import cofh.thermal.dynamics.inventory.container.ItemBufferContainer;
import cofh.thermal.dynamics.tileentity.DuctTileEnergy;
import cofh.thermal.dynamics.tileentity.DuctTileFluid;
import cofh.thermal.dynamics.tileentity.EnergyDistributorTile;
import cofh.thermal.dynamics.tileentity.ItemBufferTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.lib.util.constants.Constants.ID_THERMAL_DYNAMICS;
import static cofh.thermal.dynamics.init.TDynIDs.*;

@ObjectHolder (ID_THERMAL)
public class TDynReferences {

    private TDynReferences() {

    }

    @ObjectHolder (ID_THERMAL_DYNAMICS + ":" + ID_ENERGY_GRID)
    public static final IGridType<IEnergyGrid> ENERGY_GRID = null;
    @ObjectHolder (ID_THERMAL_DYNAMICS + ":" + ID_FLUID_GRID)
    public static final IGridType<IFluidGrid> FLUID_GRID = null;
    @ObjectHolder (ID_THERMAL_DYNAMICS + ":" + ID_ITEM_GRID)
    public static final IGridType<IItemGrid> ITEM_GRID = null;
    @ObjectHolder (ID_THERMAL_DYNAMICS + ":" + ID_MULTI_GRID)
    public static final IGridType<IMultiGrid> MULTI_GRID = null;

    @ObjectHolder (ID_ENERGY_DUCT)
    public static final Block ENERGY_DUCT_BLOCK = null;
    @ObjectHolder (ID_ENERGY_DUCT)
    public static final TileEntityType<DuctTileEnergy> ENERGY_DUCT_TILE = null;

    @ObjectHolder (ID_FLUID_DUCT)
    public static final Block FLUID_DUCT_BLOCK = null;
    @ObjectHolder (ID_FLUID_DUCT)
    public static final TileEntityType<DuctTileFluid> FLUID_DUCT_TILE = null;

    //    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    //    public static final Block DEVICE_FLUID_BUFFER_BLOCK = null;
    //    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    //    public static final TileEntityType<DeviceFluidBufferTile> DEVICE_FLUID_BUFFER_TILE = null;
    //    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    //    public static final ContainerType<DeviceFluidBufferContainer> DEVICE_FLUID_BUFFER_CONTAINER = null;

    @ObjectHolder (ID_ENERGY_DISTRIBUTOR)
    public static final Block ENERGY_DISTRIBUTOR_BLOCK = null;
    @ObjectHolder (ID_ENERGY_DISTRIBUTOR)
    public static final TileEntityType<EnergyDistributorTile> ENERGY_DISTRIBUTOR_TILE = null;
    @ObjectHolder (ID_ENERGY_DISTRIBUTOR)
    public static final ContainerType<EnergyDistributorContainer> ENERGY_DISTRIBUTOR_CONTAINER = null;

    @ObjectHolder (ID_ITEM_BUFFER)
    public static final Block ITEM_BUFFER_BLOCK = null;
    @ObjectHolder (ID_ITEM_BUFFER)
    public static final TileEntityType<ItemBufferTile> ITEM_BUFFER_TILE = null;
    @ObjectHolder (ID_ITEM_BUFFER)
    public static final ContainerType<ItemBufferContainer> ITEM_BUFFER_CONTAINER = null;

}
