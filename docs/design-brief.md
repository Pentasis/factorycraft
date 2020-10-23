FactoryCraft

The main purpose of this mod is to provide a flexible & compacts approach to automation, partly based on rreal-life.

This mod adds the following:

## Cable Conduit
- Can only connect to two sides.
- Contain 16 virtual, colour-coded cable bundles
- Each bundle contains 32 virtual cables (numbered 0 - 31)
- Each cable has 16 virtual wires which carry a 16-bit signal.
Should render as a 4x4 against wall, ceiling or floor.

### Signals
The signed range of integer values that can be stored in 16 bits is −32,768 (−1 × 215) through 32,767 (215 − 1); the unsigned range is 0 through 65,535 (216 − 1).
Floats are currently not implemented! (may add this in future)
Redstone values are always transmitted in the least significant nybble (if not specified).
A logical 0 or 1 is always transmitted in the least significant bit (if not specified).

### Cable bender
The cable bender is an item (tool) that allows you to 'bend' a cable to alter which way it connects.

### Connection box
Allows for 2-4 bundled cables to connect to each other.

## PLC
A Programmable Logic Controller (PLC) which can be programmed with either the Ladder Diagram (LD) or the Instruction List (IL) languages.
I have tried to keep as close as possible to the IEC 61131-3 standard.

PLCs are very versatile and powerful devices that are used all over the world to control factories.

The PLC has 2 rows of 8x8 terminals (64 input wires, and 64 output wires).

The PLC has functions that do not exist in Real life:
- RS2BOOL converts redstone values 0 to 7 to a logical 0, and values 8 to 15 to a logical 1
- Send/Test ItemID/EntityID/BiomeID/etc.

## Instrumentation
Basically these are all machines, instruments, sensors, etc. used to control your factory.

They have built-in terminal GUIs. Each terminal is coded: bundlecolor-cable#-wire#
OR: Use an intermediary I/O connector?
Commonly used terminals are:
- Redstone input (send/write)
- Redstone output (read)
- Power used
- Power stored
- Scan item
- Scan entity
- Scan inventory (slot#)
- Signal value (e.g. a string or integer) (Command function)
- Other (E.g. damage or tool-damage, etc.)

Types of instruments:
- Inventory Scanner
- Area Scanner
- Switches
- Push Buttons
- Valves
- Solenoids
- Indicator lights
- Gauges
- Displays
- Redstone connector
- Screen
- Show amount of items/blocks in container or slot
- Show detected entity
- Show redstone value, used/stored power, Name of machine/instrument

## Control Panel
A control panel is a configurable GUI that allows you to create switches, buttons, indicators, etc. in one screen.
It has 2 rows of 8x8 terminals.

## Transport
### Power
Cables. Can be controlled with switch or relay.
Switches & relays go in-line. Switches expose to face (cable-bender controlled)
NB: In-line means they do not output a Rs-signal but have a state (open/closed)

### Fluid
Pipes. Can be controlled with valves/solenoids.
Valves and solenoids go in-line. Valves expose to face (cable bender controlled)
NB: In-line means they do not output a Rs-signal but have a state (open/closed)

### Gas
Pipes. Idem.

### Items
#### Conveyor belts

#### rail-functionality




## Notation in PLC
Input and Output have coloured background indicating the cable and a number indicating he wire.
Adding a dot-notation allows for bit selection. E.g. I7.1

