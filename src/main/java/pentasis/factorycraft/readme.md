FactoryCraft

The main purpose of this mod is to provide a flexible & compacts approach to automation, partly based on rreal-life.

This mod adds the following:

## Bundled Signal Cables
- Can only connect to two sides.
- Contain 16 virtual, colour-coded signal cables
- Each signal cables contains 8 virtual wires (numbered 0 - 7)

### Cable bender
The cable bender is an item (tool) that allows you to 'bend' a cable to alter which way it connects.

### Connector ??
Connects a bundled cable to a machine or device.

### Connection box
Allows for 6 bundled cables to connect to each other. And/Or connects a cable to a machine/device.

### Terminal board
Allows for 4 bundled cables. Has 4 terminal rows with 128 terminals each. Allows for cross-wiring.

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

They have built-in terminal GUIs.
Commonly used terminals are:
- Redstone input
- Redstone output
- Power used
- Power stored
- Scan item
- Scan entity
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
- Show amount of items/blocks in container
- Show detected entity
- Show redstone value, used/stored power, Name of machine/instrument

## Control Panel
A control panel is a configurable GUI that allows you to create switches, buttons, indicators, etc. in one screen.
It has 2 rows of 8x8 terminals.

## Transport
### Power
Cables. Can be controlled with switch or relay.
Switches & relays go in-line. Switches expose to face (cable-bender controlled)

### Fluid
Pipes. Can be controlled with valves/solenoids.
Valves and solenoids go in-line. Valves expose to face (cable bender controlled)

### Gas
Pipes. Idem.

### Items
#### Conveyor belts

#### rail-functionality


## Signals
All signals are 16-bit, so each wire can potentially carry 16 signals at once or:
The signed range of integer values that can be stored in 16 bits is −32,768 (−1 × 215) through 32,767 (215 − 1); the unsigned range is 0 through 65,535 (216 − 1).
Floats are currently not implemented! (may add this in future)
Redstone values are always transmitted in the least significant nybble (if not specified).
A logical 0 or 1 is always transmitted in the least significant bit (if not specified).

## Notation in PLC
Input and Output have coloured background indicating the cable and a number indicating he wire.
Adding a dot-notation allows for bit selection. E.g. I7.1

