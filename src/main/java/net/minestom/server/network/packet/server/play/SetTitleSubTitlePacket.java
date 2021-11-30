package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public record SetTitleSubTitlePacket(Component subtitle) implements ServerPacket {
    public SetTitleSubTitlePacket(BinaryReader reader) {
        this(reader.readComponent());
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeComponent(subtitle);
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SET_TITLE_SUBTITLE;
    }
}
