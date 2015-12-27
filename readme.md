[JourneyMap API](https://bitbucket.org/TeamJM/journeymap-api)
====

An API for integrating mods with [JourneyMap for Minecraft](http://journeymap.info).  Allows mods to create waypoints
and place overlays and markers in one or more map displays within JourneyMap.

Integrating this Code into your Mod
===

This API is currently being developed and is likely to change. 

**It doesn't work with JourneyMap yet.**

You're seeing it so you can provide feedback to Techbrew on Espernet IRC #journeymap before he finalizes 
it and starts implementing it in JourneyMap.

This page will be updated as development progresses.

Dependencies
===
The only dependencies for this API are for libraries already included with Minecraft and Forge:

* Guava
* Gson
* Forge (just for the @ API annotation)
* JUnit

Building Code in this Repository
===

**Assumptions:**

1. You already know how to use Git and Gradle.
2. You already have Forge built in your local Gradle repo.

Simply run the Gradle 'build' task to generate the following:

* */build/libs/journeymap-api-#.jar*
* */build/libs/journeymap-api-#-javadoc.jar*
* */build/libs/journeymap-api-#-sources.jar*

Help Wanted
===
If you have suggestions or improvements to the API structure, feel free to make Pull Requests. Chatting with the TeamJM
developers in Espernet IRC #journeymap is highly suggested.  Before you change anything or submit code, however, be sure
to read the **Licence Information** below.

**Areas of help needed:**

* Unit tests!
* Utility classes utilizing [java.awt.geom.Area.add()](https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Area.html) to 
create optimized polygons comprised of multiple chunks.
* A sample mod project using the API that:
    * Displays slime chunks in JourneyMap
    * Shows how to include the .classes from the journeymap-api jar in another mod
    * Shows how to check ClientAPIFactory.isJourneyMapPresent() in the mod's post-init phase 

License Information
===

All code in this journeymap-api repository is Copyright (c) Techbrew.  **All Rights Reserved.**

*However, the following limited rights are granted to you:*

**You MAY:**

* Write your own code that uses the API source code herein as a dependency.
* Distribute compiled classes of unmodified API source code which your code depends upon.
* Fork and modify API source code for the purpose of submitting Pull Requests to the this repository. Submitting new or modified code to the repository eans that you are granting Techbrew all rights over the code.

**You MAY NOT:**
 
* Submit any code to this repository with a different license than this one.
* Distribute modified versions of the API source code or compiled artifacts of modified API source code. In this context, "modified" means changes which have not been both approved and merged into this repository.
* Use or distribute the API code in any way not explicitly granted by this license statement.