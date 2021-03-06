package me.carleslc.commands;

import me.carleslc.interactiveJava.Command;
import me.carleslc.interactiveJava.console.Console;
import me.carleslc.utils.StringUtils;

public class Echo implements Command {

	@Override
	public String execute(Console console, String[] args) {
		if (args.length == 2) {
			if (args[1].equalsIgnoreCase("off"))
				console.enablePrinting(false);
			else if (args[1].equalsIgnoreCase("on"))
				console.enablePrinting(true);
			else
				console.printAsConsole(args[1]);
			return args[1];
		}
		else if (args.length > 2) {
			String message = StringUtils.concat(args, 1);
			console.printAsConsole(message);
			return message;
		}
		else
			console.printAsHelp(help());
		return null;
	}

	@Override
	public String help() {
		return "echo {msg} - Prints a message.\n"
				+ "echo off - Disable console output.\n"
				+ "echo on - Enable console output.";
	}

}
