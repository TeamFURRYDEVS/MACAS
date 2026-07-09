@file:Suppress("UnstableApiUsage")

package io.github.teamfurrydevs.macas.data

import io.github.teamfurrydevs.macas.definitions.AttributeData
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.storage.ValueInput
import net.minecraft.world.level.storage.ValueOutput
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent
import org.ladysnake.cca.api.v3.entity.C2SSelfMessagingComponent
import java.util.UUID

internal class PlayerDataSave(private val player: Player) : C2SSelfMessagingComponent, AutoSyncedComponent, ServerTickingComponent {
    private val attributes: MutableMap<UUID, AttributeData> = mutableMapOf()

    override fun handleC2SMessage(buf: RegistryFriendlyByteBuf) {
        TODO("Not yet implemented")
    }

    override fun readData(readView: ValueInput) {
        TODO("Not yet implemented")
    }

    override fun writeData(writeView: ValueOutput) {
        TODO("Not yet implemented")
    }

    override fun serverTick() {
        TODO("Not yet implemented")
    }

}