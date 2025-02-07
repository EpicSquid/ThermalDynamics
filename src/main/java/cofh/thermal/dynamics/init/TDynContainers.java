package cofh.thermal.dynamics.init;

import cofh.core.util.ProxyUtils;
import cofh.thermal.dynamics.inventory.container.logistics.LogisticsItemBufferContainer;
import net.minecraftforge.common.extensions.IForgeContainerType;

import static cofh.thermal.core.ThermalCore.CONTAINERS;
import static cofh.thermal.dynamics.init.TDynIDs.ID_LOGISTICS_ITEM_BUFFER;

public class TDynContainers {

    private TDynContainers() {

    }

    public static void register() {

        CONTAINERS.register(ID_LOGISTICS_ITEM_BUFFER, () -> IForgeContainerType.create((windowId, inv, data) -> new LogisticsItemBufferContainer(windowId, ProxyUtils.getClientWorld(), data.readBlockPos(), inv, ProxyUtils.getClientPlayer())));
    }

}
