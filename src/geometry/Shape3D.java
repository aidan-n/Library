package geometry;

/**
 * Represents a shape usable within a 3-dimensional plane.
 * 
 * @see geometry.Point3D
 * 
 * @author Albert Beaupre
 */
public interface Shape3D {

    /**
     * Checks if the specified {@code Point3D} is contained within the bounds of
     * this {@code Shape} and returns {@code true} if so.
     * 
     * @param point
     *            the {@code Point3D} to check if it is within the bounds of
     *            this {@code Shape}
     * 
     * @return {@code true} if the point is within the bounds; return
     *         {@code false} otherwise
     */
    public boolean contains(Point3D point);

    /**
     * Checks if the specified {@code (x,y,z)} coordinates are contained within
     * the bounds of this {@code Shape} and returns {@code true} if so.
     * 
     * @param x
     *            The X location of the coordinates to check
     * @param y
     *            The Y location of the coordinates to check
     * @param z
     *            The Z location of the coordinates to check
     * 
     * @return {@code true} if the {@code (x,y,z)} coordinates are within the
     *         bounds; return {@code false} otherwise
     */
    public default boolean contains(int x, int y, int z) {
	return contains(new Point3D(x, y, z));
    }

    /**
     * Checks if the specified {@code Shape3D} will intersect with this
     * {@code Shape3D} and returns {@code true} if so.
     * 
     * @param shape
     *            the {@code Shape3D} to check if it is intersecting with this
     *            one
     * 
     * @return true if this {@code Shape3D} intersects with the specified
     *         {@code Shape3D}; return {@code false} otherwise
     */
    public boolean intersects(Shape3D shape);

}
