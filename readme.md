# Arachne Demo 1

This is a simple demo of some of Arachne's basic features, using only the core, http and Pedestal modules.

To get started, look at the `src/arachne_demo_1.clj` file. The `-main` function does all that is necessary to load an Arachne config, and start the Arachne runtime. For interactive exploration at the REPL, you can also use the code in the comment block below the `-main` function.

The project is actually three projects in one, and comes with three different Arachne config scripts.

- `"config/simple.clj"` - starts a single background task
- `"config/web.clj"` - starts a Pedestal web server with a hello-world endpoint
- `"config/system.clj"` - combines the background task with a HTTP endpoint that can observe its current state.
