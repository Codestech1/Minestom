package net.minestom.server.command.builder.arguments;

import net.minestom.server.command.builder.exception.ArgumentSyntaxException;
import net.minestom.server.network.packet.server.play.DeclareCommandsPacket;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a boolean value.
 * <p>
 * Example: true
 */
public class ArgumentBoolean extends Argument<Boolean> {

    public static final int NOT_BOOLEAN_ERROR = 1;

    public ArgumentBoolean(String id) {
        super(id);
    }

    @NotNull
    @Override
    public Boolean parse(@NotNull String input) throws ArgumentSyntaxException {
        if (input.equalsIgnoreCase("true"))
            return true;
        if (input.equalsIgnoreCase("false"))
            return false;

        throw new ArgumentSyntaxException("Not a boolean", input, NOT_BOOLEAN_ERROR);
    }

    @NotNull
    @Override
    public DeclareCommandsPacket.Node[] toNodes(boolean executable) {
        DeclareCommandsPacket.Node argumentNode = COMMAND_MANAGER.simpleArgumentNode(this, executable, false);

        argumentNode.parser = "brigadier:bool";

        return new DeclareCommandsPacket.Node[]{argumentNode};
    }

}
