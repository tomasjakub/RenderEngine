package vertexDataStoring;

import java.nio.ByteBuffer;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import utils.Colour;
import utils.DataUtils;


public class DataStoring {

	public static void packVertexData(Vector3f position, Vector3f normal, Colour colour, ByteBuffer buffer) {
		packVertexData(position.x, position.y, position.z, normal, colour, buffer);
	}


	public static void packVertexData(Vector2f position, byte[] indicators, ByteBuffer buffer) {
		buffer.putFloat(position.x);
		buffer.putFloat(position.y);
		buffer.put(indicators);
	}

	public static void packVertexData(float x, float y, float z, Vector3f normal, Colour colour, ByteBuffer buffer) {
		store3Floats(buffer, x, y, z);
		storeNormal(buffer, normal);
		storeColour(buffer, colour);
	}

	public static void packVertexData(float x, float y, float z, Colour colour, ByteBuffer buffer) {
		store3Floats(buffer, x, y, z);
		storeColour(buffer, colour);
	}

	private static void store3Floats(ByteBuffer buffer, float a, float b, float c) {
		buffer.putFloat(a);
		buffer.putFloat(b);
		buffer.putFloat(c);
	}

	private static void storeNormal(ByteBuffer buffer, Vector3f normal) {
		int packedInt = DataUtils.pack_2_10_10_10_REV_int(normal.x, normal.y, normal.z, 0);
		buffer.putInt(packedInt);
	}

	private static void storeColour(ByteBuffer buffer, Colour colour) {
		byte[] colourBytes = colour.getAsBytes();
		buffer.put(colourBytes);
	}

}
