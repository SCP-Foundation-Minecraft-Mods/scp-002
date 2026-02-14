# SCP-002 Minecraft Mod

A Minecraft mod based on SCP-002 "The Living Room" from the SCP Foundation universe.

## Overview

SCP-002 is a living, breathing room that exists in a pocket dimension. This mod brings the SCP-002 experience to Minecraft with:

- **SCP-002 Portal Block**: A mysterious portal that can be activated with redstone or the SCP-002 Key
- **SCP-002 Dimension**: A custom dimension containing the living room
- **SCP-002 Entity**: The living room itself, which can interact with players
- **Atmospheric Sounds**: Creepy ambient sounds and effects
- **SCP-002 Key**: A special item that resonates with dimensional energy

## Features

### Portal System
- Craft and place the SCP-002 Portal Block
- Activate with redstone dust or the SCP-002 Key
- Visual portal effects with particles and sounds
- Teleportation to the SCP-002 dimension

### SCP-002 Dimension
- Custom dimension with unique generation
- "Room-like" structure generation with wood planks
- Atmospheric lighting and effects
- Hostile environment with the SCP-002 entity

### SCP-002 Entity
- Large, room-sized entity that represents the living room
- Can "absorb" players who get too close
- Slow movement and pulsing effects when active
- Reflects damage back to attackers
- Causes status effects on nearby players

### Items
- **SCP-002 Key**: Craftable item that resonates with dimensional energy
- **Redstone Activation**: Use redstone dust to power the portal
- **Tooltips**: Lore-rich item descriptions

### Audio Experience
- Ambient creaking sounds
- Heartbeat-like pulsing
- Whispering effects
- Portal activation/deactivation sounds
- Entity absorption and damage sounds

## Crafting Recipes

### SCP-002 Key
```
Iron Ingot | Iron Ingot | Iron Ingot
Iron Ingot | Diamond    | Iron Ingot  
Iron Ingot | Iron Ingot | Iron Ingot
```

### Portal Activation
- **Redstone Method**: Right-click portal with redstone dust
- **Key Method**: Right-click portal with SCP-002 Key (future implementation)

## How to Use

1. **Craft the SCP-002 Key** (optional, for lore)
2. **Place the SCP-002 Portal Block**
3. **Activate with Redstone**: Right-click with redstone dust
4. **Enter the Portal**: Right-click the active portal to teleport
5. **Explore SCP-002**: Navigate the living room dimension
6. **Survive**: Avoid the SCP-002 entity's absorption effects

## Technical Implementation

### Files Structure
```
src/main/java/com/scpfoundation/scp002/
├── SCP002.java                    # Main mod class
├── blocks/
│   └── SCP002PortalBlock.java     # Portal block with teleportation
├── entities/
│   └── SCP002Entity.java          # Living room entity
├── registry/
│   ├── ModBlocks.java             # Block registration
│   ├── ModItems.java              # Item registration
│   ├── ModEntities.java           # Entity registration
│   ├── ModSounds.java             # Sound registration
│   └── ModCreativeTabs.java       # Creative tab
├── world/dimension/
│   ├── SCP002Dimension.java       # Dimension implementation
│   ├── SCP002ChunkGenerator.java  # Custom world generation
│   ├── SCP002BiomeSource.java     # Biome generation
│   ├── SCP002DimensionType.java   # Dimension properties
│   └── SCP002DimensionRegistry.java # Dimension registration
├── items/
│   └── SCP002KeyItem.java         # Key item
└── client/
    ├── ClientSetup.java           # Client-side setup
    └── render/
        └── SCP002EntityRenderer.java # Entity rendering

src/main/resources/
├── assets/scp002/
│   ├── sounds.json                # Sound definitions
│   └── textures/entity/
│       └── scp002_entity.png.mcmeta # Entity texture metadata
└── data/scp002/
    └── recipes/
        └── scp002_key.json        # Crafting recipe
```

### Key Classes

#### SCP002PortalBlock
- Handles portal activation and teleportation
- Visual effects with particles and sounds
- Can be powered by redstone or special items
- Prevents placement on non-solid blocks

#### SCP002Entity
- Represents the living room itself
- Large entity (16x8 blocks) to simulate room size
- Absorption mechanics that affect nearby players
- Damage reflection and status effect application
- Custom AI goals for targeting and movement

#### SCP002Dimension
- Custom dimension implementation
- Room-like structure generation
- Atmospheric effects and lighting
- Integration with the SCP-002 entity

## Lore Integration

This mod stays true to the SCP-002 lore:

> SCP-002 is a living, breathing room that exists in a pocket dimension. It appears to be a normal room at first, but upon closer inspection, it reveals itself to be a living organism.

- **The Portal**: Represents the doorway to the pocket dimension
- **The Entity**: The living room itself, capable of absorbing matter
- **The Atmosphere**: Creepy sounds and effects to create unease
- **The Key**: A mysterious artifact that resonates with the dimension

## Development Notes

### Current Status
✅ **Completed Features:**
- Portal block with activation mechanics
- SCP-002 entity with absorption abilities
- Custom dimension infrastructure
- Sound system with atmospheric effects
- Item system with SCP-002 key
- Recipe system for key crafting
- Entity rendering and client setup

🔄 **Future Enhancements:**
- Proper dimension teleportation (beyond coordinate teleportation)
- Advanced portal effects and animations
- More sophisticated entity AI
- Dimension-specific blocks and items
- Progressive difficulty scaling
- SCP-002 entity growth mechanics

### Technical Challenges
- Entity size management (representing a room as an entity)
- Dimension registration in newer Minecraft versions
- Sound system integration with custom categories
- Particle effects for atmospheric enhancement

## Installation

1. Ensure you have Minecraft Forge installed
2. Place the compiled mod file in your `mods` folder
3. Launch Minecraft with the mod loaded
4. Enjoy the SCP-002 experience!

## Contributing

This mod is designed to be extensible. Consider adding:

- Additional SCP entities
- More complex dimension generation
- Advanced portal mechanics
- Custom blocks and items
- Enhanced soundscapes
- Visual effects and shaders

## License

This mod is for educational and entertainment purposes. SCP content is owned by the SCP Foundation and associated contributors.

## Credits

- SCP Foundation for the original SCP-002 concept
- Minecraft Forge team for the modding framework
- Minecraft developers for the base game
- Sound effects from Minecraft's built-in audio system