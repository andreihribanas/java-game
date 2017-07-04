# Setup

To run the project it is required for the JBox2D game engine to be added to be installed into the project folder.

Download the engine32 file and import the .jar into the library folder of your project and the documentation into the Javadoc section.


# Project description

A Java implementation of the Terminator game using the JBox2D engine.


# Project main features

- The game has implemented multiple levels using inheritance ensuring the levels are significantly different;
- A graphical interface that displays information (such as health, score, etc) - use of images and on screen drawing to display in game information to the playe;
- Graphical User Interface controls: pause/restart buttons and provided zoom behaviour;
- Different kinds of dynamic body that interact with other bodies in varying ways;
- Instances of new bodies classes are rendered with images;
- The game is controllable with both the keyboard and mouse (keyboard for character movement, mouse to shoot bullets);
- A more advanced feature is an AI that responds by shooting at the player when positional criteria are met. Shooting incorporates projectile generation, sound and interaction with the player. The behaviour is implemented and contained within a single class that makes use of step listeners and conditional code.
- A second main feature is the use of a key lock mechanism implemented with collisions and GUI responses. The feature is implemented as described and is managed within a single class.