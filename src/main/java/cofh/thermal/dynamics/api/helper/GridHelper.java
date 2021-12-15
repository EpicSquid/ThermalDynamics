package cofh.thermal.dynamics.api.helper;

import cofh.thermal.dynamics.api.TDynApi;
import cofh.thermal.dynamics.api.grid.IGridHost;
import cofh.thermal.dynamics.api.grid.IGridNode;
import com.google.common.collect.ImmutableList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.util.*;

/**
 * @author covers1624
 */
public class GridHelper {

    private GridHelper() {

    }

    public static Optional<IGridHost> getGridHost(IBlockReader reader, BlockPos pos) {

        if (reader instanceof IWorldReader) {
            IWorldReader worldReader = (IWorldReader) reader;
            if (!worldReader.hasChunkAt(pos)) return Optional.empty();
        }
        return getGridHost(reader.getBlockEntity(pos));
    }

    public static Optional<IGridHost> getGridHost(@Nullable TileEntity tile) {

        if (tile == null) return Optional.empty();

        if (tile instanceof IGridHost) {
            return Optional.of((IGridHost) tile);
        }
        return tile.getCapability(TDynApi.GRID_HOST_CAPABILITY).resolve();
    }

    public static List<Pair<IGridNode<?>, Integer>> locateAttachedNodes(World world, BlockPos start, BlockPos from) {

        Set<BlockPos> visited = new HashSet<>();
        LinkedList<Pair<IGridHost, Integer>> candidates = new LinkedList<>();
        visited.add(start);
        visited.add(from);
        addCandidates(world, start, 0, visited, candidates);
        ImmutableList.Builder<Pair<IGridNode<?>, Integer>> builder = ImmutableList.builder();
        while (!candidates.isEmpty()) {
            Pair<IGridHost, Integer> candidate = candidates.pop();
            IGridHost host = candidate.getLeft();
            Optional<IGridNode<?>> nodeOpt = host.getNode();
            if (nodeOpt.isPresent()) {
                builder.add(Pair.of(nodeOpt.get(), candidate.getRight()));
            } else {
                addCandidates(world, host.getHostPos(), candidate.getRight(), visited, candidates);
            }
        }
        return builder.build();
    }

    private static void addCandidates(World world, BlockPos pos, int len, Set<BlockPos> visited, LinkedList<Pair<IGridHost, Integer>> candidates) {

        for (Direction dir : Direction.values()) {
            BlockPos adj = pos.relative(dir);
            if (!visited.add(adj)) continue;
            GridHelper.getGridHost(world, adj)
                    .ifPresent(e -> candidates.add(Pair.of(e, len + 1)));
        }
    }

}
