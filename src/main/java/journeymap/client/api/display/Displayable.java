/*
 * JourneyMap API (http://journeymap.info)
 * http://bitbucket.org/TeamJM/journeymap-api
 *
 * Copyright (c) 2011-2016 Techbrew.  All Rights Reserved.
 * The following limited rights are granted to you:
 *
 * You MAY:
 *  + Write your own code that uses the API source code in journeymap.* packages as a dependency.
 *  + Write and distribute your own code that uses, modifies, or extends the example source code in example.* packages
 *  + Fork and modify any source code for the purpose of submitting Pull Requests to the TeamJM/journeymap-api repository.
 *    Submitting new or modified code to the repository means that you are granting Techbrew all rights to the submitted code.
 *
 * You MAY NOT:
 *  - Distribute source code or classes (whether modified or not) from journeymap.* packages.
 *  - Submit any code to the TeamJM/journeymap-api repository with a different license than this one.
 *  - Use code or artifacts from the repository in any way not explicitly granted by this license.
 *
 */

package journeymap.client.api.display;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

/**
 * Base class for Overlays and Waypoints.
 */
@ParametersAreNonnullByDefault
public abstract class Displayable implements Comparable<Displayable>
{
    protected final String modId;
    protected final String displayId;
    protected final DisplayType displayType;

    protected Displayable()
    {
        modId = null;
        displayId = null;
        displayType = null;
    }

    /**
     * Constructor which will generate a GUID display id.
     *
     * @param modId     the mod id
     */
    Displayable(String modId)
    {
        this(modId, UUID.randomUUID().toString(), null);
    }

    /**
     * Constructor with explicit display id.
     *
     * @param modId     the mod id
     * @param displayId the display id
     */
    Displayable(String modId, String displayId)
    {
        this(modId, displayId, null);
    }

    /**
     * Constructor with explicit display id and type.
     * Warning: Mods should not subclass Displayable nor use this constructor.
     *
     * @param modId       the mod id
     * @param displayId   the display id
     * @param displayType displayType
     */
    Displayable(String modId, String displayId, @Nullable DisplayType displayType)
    {
        if (Strings.isNullOrEmpty(modId))
        {
            throw new IllegalArgumentException("modId may not be blank");
        }
        if (Strings.isNullOrEmpty(displayId))
        {
            throw new IllegalArgumentException("displayId may not be blank");
        }
        this.modId = modId;
        this.displayId = displayId;
        this.displayType = displayType == null ? DisplayType.of(getClass()) : displayType;
    }

    /**
     * Clamps an rgb int value to the allowable range.
     * If an ARGB value is passed in, alpha is masked to FF.
     *
     * @param rgb color
     * @return clamped color
     */
    public static int clampRGB(int rgb)
    {
        return 0xff000000 | rgb;
    }

    /**
     * Clamps an rgb int value to the allowable range of 0F-1F.
     *
     * @param opacity opacity
     * @return clamped opacity
     */
    public static float clampOpacity(float opacity)
    {
        return Math.max(0F, Math.min(opacity, 1F));
    }

    /**
     * Used to determine display order, lower first.
     * @return order
     */
    public abstract int getDisplayOrder();

    /**
     * Your mod id.
     *
     * @return modId mod id
     */
    public final String getModId()
    {
        return modId;
    }

    /**
     * A unique id for the object. Uniqueness is only needed among instances of the same class.
     *
     * @return displayId display id
     */
    public final String getId()
    {
        return displayId;
    }

    /**
     * DisplayType enum for the object.
     *
     * @return enum value
     */
    public final DisplayType getDisplayType()
    {
        return displayType;
    }

    /**
     * Colon-delimited GUID for the display object in the form of "modid:displayType:displayId".
     *
     * @return the guid
     */
    public final String getGuid()
    {
        return Joiner.on(":").join(modId, displayType, displayId);
    }

    /**
     * Equality is based on either reference equality or GUID.
     *
     * @param o other
     * @return true if equal
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Displayable))
        {
            return false;
        }
        Displayable that = (Displayable) o;
        return Objects.equal(modId, that.modId) &&
                Objects.equal(displayType, that.displayType) &&
                Objects.equal(displayId, that.displayId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(modId, displayType, displayId);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Displayable o)
    {
        return Integer.compare(getDisplayOrder(), o.getDisplayOrder());
    }
}
